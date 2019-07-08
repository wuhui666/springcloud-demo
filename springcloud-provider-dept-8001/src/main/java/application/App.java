package application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: wuhui
 * @time: 2019/7/1 13:30
 * @desc:
 */
@SpringBootApplication
@MapperScan(basePackages = {"application.mappers"})
@EnableDiscoveryClient
@EnableCircuitBreaker/*开启服务熔断*/
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
