package application.controller;

import application.pojo.Dept;
import application.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    /*服务降级*/
    /*结合feign其实可以抽取出降级方法，如Provider-8001里*/
    @GetMapping("/dept/{id}")
    @HystrixCommand(fallbackMethod = "fallback",

            commandProperties ={
                    @HystrixProperty(name = "circuitBreaker.enabled",value ="true"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
            } )
    /*当在一个时间窗口（sleepWindowInMilliseconds）内请求数量达到requestVolumeThreshold（10）个会进行判断熔断与否，请求中错误请求的比例到达errorThresholdPercentage（60%）,
    就打开熔断器，一律将请求交给降级服务，打开状态有个时间（sleepWindowInMilliseconds）来限制，过了这个时间就会进入
    半熔断状态，此时允许一部分请求访问未降级服务，如果调用正常服务全都成功或者达到了一定比例
    就会恢复到关闭状态，否则认为还有问题，就回到打开状态，限制时间刷新重置:*/
    public Dept getById(@PathVariable("id") Long id) throws IOException {
        if (id<2){
            System.out.println("dept----8001");
            /*模拟耗时*/
            /*try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            return deptService.findDeptById(id);
        }
        else {
            /*制造异常,引起服务降级*/
            throw new IOException();
        }


    }
    public Dept fallback(@PathVariable("id") Long id){
        Dept dept = new Dept();
        dept.setDeptNo(500L);
        dept.setDeptName("系统繁忙啦！");
        dept.setDbSource("请稍后重试");
        return dept;
    }
}
