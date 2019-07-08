package dept_consumer_80;

import dept_consumer_80.config.MyFeignRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: wuhui
 * @time: 2019/7/1 17:17
 * @desc:
 */
@SpringBootApplication
@EnableFeignClients
//@EnableFeignClients(defaultConfiguration = MyFeignRule.class) //这样可以指定策略，不过yml里策略没必要配了
@EnableHystrixDashboard
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
