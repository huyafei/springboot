# 介绍
初学java，没有经验，小白一个，练习demo记录一下，有些问题虽然解决了但是不懂
# 说明
每个版本都在其上一个版本增加内容  
### v1  
功能:
   1. 新建项目
   2. 简单处理跨域
   3. 编写简单请求
   
参考: 
  1. [idea新建springboot项目](https://www.cnblogs.com/swzx-1213/p/12345330.html)  
  2. [idea+SpringBoot整合Mybatis完成增删改查功能](https://blog.csdn.net/wqbs369/article/details/83090517)
  3. [详解SpringBoot应用跨域访问解决方案](https://www.cnblogs.com/xuxiaobai13/p/11950344.html)
  
### v2
接口测试: postman  
功能:    
   1. 完善/增加接口(增删改查)
   2. 配置统一返回数据格式
   3. 添加简单全局统一异常处理  
   
参考:  
   1. [SpringBoot，Spring 中常用注解@RequestMapping/@GetMapping/@PostMapping /@PutMapping/@DeleteMapping介绍](https://www.cnblogs.com/m2492565210/p/10652967.html)
   2. [springBoot中对于model层、dao层、service层、controller层的理解](https://blog.csdn.net/mzc_love/article/details/106564640)
   3. [springboot使用mybatis插入数据返回数据的id](https://blog.csdn.net/qq_37164847/article/details/82016762)
   4. [SpringBoot获取http请求参数的方法](cnblogs.com/wjw1014/p/11611312.html)
   5. [springboot封装统一返回数据格式和异常处理](https://www.pianshen.com/article/234513229/)
### v3  
功能:  
   1. 处理浏览器直接打开接口地址显示乱码问题
   2. 获取列表接口实现分页  
   
问题:  
   1. 部分浏览器直接打开接口返回数据乱码
   
    ```
        // 用这个无效  
        server.http.encoding.charset=UTF-8
        server.http.encoding.force=true
        server.http.encoding.enabled=true  
        // 下面有效
        server.servlet.encoding.charset=UTF-8
        server.servlet.encoding.force=true
        server.servlet.encoding.enabled=true  
    ```
    
   2. 使用pagehelper(参考2)进行列表分页，排序无效，
   
    ```
        // 参考2 引入
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.2.13</version>
        </dependency>
        //还需引入 参考3
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-autoconfigure</artifactId>
            <version>1.2.13</version>
        </dependency>
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>5.1.11</version>
        </dependency>
        
    ```
   
参考:  
   1. [springboot配置字符编码](https://www.cnblogs.com/quintanliu/p/13428440.html)
   2. [Spring Boot：实现MyBatis分页](https://www.cnblogs.com/xifengxiaoma/p/11027551.html)
   3. [springboot集合pagehelper分页不生效的原因](https://www.cnblogs.com/xd1105/p/10942266.html)
