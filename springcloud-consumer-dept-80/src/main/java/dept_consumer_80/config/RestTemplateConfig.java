package dept_consumer_80.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: wuhui
 * @time: 2019/7/1 16:52
 * @desc:
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced //@LoadBalanced不能和LoadBalancedlient混用
    public RestTemplate client(){
        return new RestTemplate();
    }
    /*指定策略*/
    /*@Bean
    public IRule myRule(){

        return new RandomRule();//随机//return new RoundRobinRule();//轮询
    }*/


}
