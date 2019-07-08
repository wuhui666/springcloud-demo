package dept_consumer_80.config;

import application.pojo.Dept;
import dept_consumer_80.Feign_Interface.DeptService;
import feign.hystrix.FallbackFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author: wuhui
 * @time: 2019/7/3 10:13
 * @desc: feign与接口的绑定
 */
@Component/*别忘了加入容器*/
public class MyFallbackHanlder implements DeptService {
    @Override
    public Dept getDeptById(long id) {
        Dept dept = new Dept();
        dept.setDeptNo(500L);
        dept.setDeptName("系统繁忙啦！");
        dept.setDbSource("请稍后重试");
        return dept;
    }
}
