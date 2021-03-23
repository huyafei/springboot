package com.company.demo.controller;

import com.company.demo.annotation.UserLoginToken;
import com.company.demo.entity.Cost;
import com.company.demo.entity.Result;
import com.company.demo.service.CostService;
import com.company.demo.utils.PageRequest;
import com.company.demo.utils.PageResult;
import com.company.demo.utils.ResultUtil;
import com.company.demo.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/*
 * 1.@Controller和@RestController区别
 *   @Controller 用来响应页面，表示当前的类为控制器。
 *   @RestController 是@ResponseBody和@Controller的结合，表明当前类是控制器且返回的是一组数据，不是页面
 * 2.@Autowired自动注入
 * 3.@RequestMapping和@PostMapping、@DeleteMapping、@PutMapping、@GetMapping、@PatchMapping区别
 *   @RequestMapping 当前台界面调用Controller处理数据时候告诉控制器怎么操作,作用：URL映射
 *   @*Mapping 表明是一个*URL映射
 *   后者是前者的语义化简写，例如:
 *       @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)，语义化简写 @GetMapping("/get/{id}") 或者 @GetMapping(value="/get/{id}")
 * 4.请求传参
 *   4.1 路径传参
 *       http://localhost/jayvee/demo/addUser4/wjw/123465
 *      @PathVariable 如下
 *   4.2 get传参
 *       http://localhost/jayvee/demo/addUser?username=wjw&password=123456
 *       @RequestParam
 *       @RequestParam("name") String name
 *       语法：@RequestParam(value=”参数名”,required=”true/false”,defaultValue=””)如下
 *   4.3 post传参
 *      参数放在请求主体中(body)
 *      @RequestBody
 * */
@RestController
@RequestMapping("/api")
public class CostController {
    @Autowired
    private CostService costService;

    /**
     * 新增资费
     * post传参 参数放在body中
     *
     * @param cost
     * @return
     */
//    @UserLoginToken
    @PostMapping("/cost")
    public Result insertCost(@RequestBody Cost cost) {
        Date date = new Date();
        cost.setCreateTime(date);
        cost.setUpdateTime(date);
        costService.insertCost(cost);
        return ResultUtil.success(costService.selectCostById(cost.getId()));
    }

    /**
     * 删除资费
     * 路径传参
     *
     * @param id
     * @return
     */
//    @UserLoginToken
    @DeleteMapping("/cost/{id}")
    public Result deleteCost(@PathVariable("id") Integer id) {
        costService.deleteCost(id);
        return ResultUtil.success();
    }

    /**
     * 修改资费
     * 参数放在body
     *
     * @param cost
     */
//    @UserLoginToken
    @PutMapping("/cost")
    public Result updateCost(@RequestBody Cost cost) {
        if (cost.getId() == null || costService.selectCostById(cost.getId()) == null) {
            return  ResultUtil.errorParam("'参数id错误'");
        }
        Date date=new Date();
        cost.setUpdateTime(date);
        costService.updateCost(cost);
        return ResultUtil.success();
    }

    /**
     * 查 详情
     * 路径传参
     * @param id 资费id
     * @return 资费实体
     */
    @GetMapping(value = "/cost/{id}")
    public Result selectCostById(@PathVariable("id") Integer id) {
        Cost cost = costService.selectCostById(id);
        return ResultUtil.success(cost);
    }

    /**
     * 查 所有
     * get传参
     *
     * @return
     */
    @RequestMapping(value = "/cost-list", method = RequestMethod.GET)
    public Result selectCostList() {
        List<Cost> list = costService.selectCostList();
        return ResultUtil.success(list);
    }

    /**
     *
     * @param sort 排序 默认：createTime asc
     * @param page 分页
     * @param cost 条件筛选
     * @return
     */
    @RequestMapping(value = "/cost-list-page", method = RequestMethod.GET)
    public Result selectCostListPage(@RequestParam(name="sort",required = false,defaultValue="createTime asc") String sort, PageRequest page, Cost cost) {
        String[] sortArr = sort.split(" ");
        String fieldName = StringUtil.camel2Underline(sortArr[0], true);
        PageResult list = costService.selectCostListPage(page,cost,fieldName + " " + sortArr[1]);
        return ResultUtil.success(list);
    }
}
