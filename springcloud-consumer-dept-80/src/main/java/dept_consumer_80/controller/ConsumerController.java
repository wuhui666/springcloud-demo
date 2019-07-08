package dept_consumer_80.controller;


import application.pojo.Dept;
import dept_consumer_80.Feign_Interface.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author: wuhui
 * @time: 2019/7/1 17:01
 * @desc:
 */
@RestController
public class ConsumerController {
    /*如果用了Feign,你就当下面都是垃圾吧！*/
    @Autowired
    DeptService deptService;
    @GetMapping("/consumer/dept/{id}")
    public Dept getDepById(@PathVariable("id") Long id){
        return deptService.getDeptById(id);
    }
    /*其实推荐上面的feign,因为封装了restTemplate,下面是原生restTemplate*/

    /*方法一：ip+端口方式*/
   /* @Autowired
    RestTemplate template;
    @GetMapping("/consumer/dept/{id}")
    public Dept getById(@PathVariable("id") Long id){
        return template.getForObject("http://localhost:8001/dept/"+id, Dept.class);
    }*/
    /*方法二=============[推荐使用]==========================：
    通过在RestTemplate配置类创造bean的方法上添加
    @loadbalance注解实现负载均衡，然后直接而且只能通过服务名调用*/
    /*@Autowired
    RestTemplate restTemplate;
    @GetMapping("/consumer/dept/{id}")
    public Dept getById(@PathVariable("id") Long id){

        return restTemplate.getForObject("http://DEPT-PROVIDER/dept/"+id, Dept.class);

    }*/

    /*方法三：通过DiscoryClient*/
   /* @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer/dept/{id}")
    public Dept getById(@PathVariable("id") Long id){
        List<ServiceInstance> list = discoveryClient.getInstances("DEPT_PROVIDER");
            if (list != null) {
                for (ServiceInstance serviceInstance : list) {
                    System.out.println(serviceInstance.getServiceId());
                    if (serviceInstance.getServiceId().equals("DEPT_PROVIDER")){
                        System.out.println("999");
                        return restTemplate.getForObject(serviceInstance.getUri()+"/dept/"+id, Dept.class);
                    }
                }
                System.out.println("888");
            }
            System.out.println("999----");
            return null;

    }*/
   /*方法四：LoadBalancerClient，负载均衡*/
   /* @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/consumer/dept/{id}")
    public Dept getById(@PathVariable("id") Long id){
        ServiceInstance instance = loadBalancerClient.choose("DEPT_PROVIDER");
        System.out.println(instance.getUri());
        return restTemplate.getForObject(instance.getUri()+"/dept/"+id, Dept.class);

    }*/
}
