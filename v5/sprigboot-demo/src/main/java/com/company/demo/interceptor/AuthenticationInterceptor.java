package com.company.demo.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.company.demo.annotation.PassToken;
import com.company.demo.annotation.UserLoginToken;
import com.company.demo.entity.Admin;
import com.company.demo.service.AdminService;
import com.company.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
/**
 * token验证step3
 * 新建一个 AuthenticationInterceptor  实现HandlerInterceptor接口  实现拦截还是放通的逻辑
 * // 自定义拦截器时，实现 HandlerInterceptor 接口需要实现接口的所有方法，如果只需要某一个方法可以继承 HandlerInterceptorAdapter
 *
 * @author yf.hu
 * @version 1.0
 * @date 2020/10/29 17:03
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    AdminService adminService;

    /**
     * 预处理回调方法，实现处理器的预处理（如检查登陆），第三个参数为响应的处理器，自定义Controller
     * 返回值：true表示继续流程（如调用下一个拦截器或处理器）；false表示流程中断
     * （如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
     * request : 是指经过spring封装的请求对象, 包含请求地址, 头, 参数, body(流)等信息.
     * response:是指经过spring封装的响应对象, 包含输入流, 响应body类型等信息.
     * handler,是指controller的@Controller注解下的"完整"方法名, 是包含exception等字段信息的.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //得到请求头 header
        String token = request.getHeader("Token");
        // 如果不是映射到方法直接通过 instanceof 左边是否是右边的实例
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有 PassToken 注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("201"); //201 没有token 登录
                }
                // 获取 token 中的  id
                String id;
                try {
                    id = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("204"); //204 无效token
                }
                Admin admin = adminService.findById(Integer.parseInt(id));
//                Admin admin=JSON.parseObject(JSON.toJSONString(adminService.findById(Integer.parseInt(id))), Admin.class);
                System.out.println(admin);
                if (admin == null) {
                    throw new RuntimeException("203");//用户不存在，请重新登录
                }
                // 验证 token
                try {
                    JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(admin.getPassword())).build();
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("205"); //登录过期，请重新登录
                }
                return true;
            }
        }
        return true;
    }

    // 处理执行后、视图处理前调用。此时可以通过 ModelAndView 对象模型数据处理或对视图进行处理
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle()");
    }

    // 整个请求处理完毕后调用，在此可以计算性能监控的结束时间并输出消耗时间，可以进行一些资源清理，只有 preHandle 为 true，才会执行 afterCompletion
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion()");
    }

}
