package application.controller;

import application.pojo.Dept;
import application.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author: wuhui
 * @time: 2019/7/1 13:40
 * @desc:
 */
@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/dept/{id}")
    //@HystrixCommand(fallbackMethod = "fallback") //注解不用了，comsumer方已经抽取了fallback处理类
    public Dept getById(@PathVariable("id") Long id) throws IOException {
        if (id<2){
            System.out.println("dept----8001");
            return deptService.findDeptById(id);
        }
        else {
            /*制造异常,引起服务降级*/
            throw new IOException();
        }


    }

    /*服务降级*/
    /*由于feign已经有fallback处理类，这边就不需要要了*/
    /*public Dept fallback(@PathVariable("id") Long id){
        Dept dept = new Dept();
        dept.setDeptNo(500L);
        dept.setDeptName("系统繁忙啦！");
        dept.setDbSource("请稍后重试");
        return dept;
    }*/
}
