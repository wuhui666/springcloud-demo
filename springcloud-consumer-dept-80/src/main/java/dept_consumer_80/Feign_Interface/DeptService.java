package dept_consumer_80.Feign_Interface;

import application.pojo.Dept;
import dept_consumer_80.config.MyFallbackHanlder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: wuhui
 * @time: 2019/7/2 22:36
 * @desc:
 */
/*@FeignClient(value = "DEPT-PROVIDER")//服务名*/

//为了解决每个方法都搞个@HystrixCommand的臃肿，
// 可以在这里抽取到一个类集中实现fallback方法
@FeignClient(value = "DEPT-PROVIDER",fallback = MyFallbackHanlder.class)
public interface DeptService {
    @GetMapping("/dept/{id}")
    Dept getDeptById(@PathVariable("id") long id);
}
