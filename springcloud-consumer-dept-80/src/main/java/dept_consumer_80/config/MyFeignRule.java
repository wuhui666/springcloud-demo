package dept_consumer_80.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wuhui
 * @time: 2019/7/2 23:08
 * @desc:
 */
@Configuration
public class MyFeignRule {
    @Bean
    public IRule myRule(){
        return new RoundRobinRule();
    }
}
