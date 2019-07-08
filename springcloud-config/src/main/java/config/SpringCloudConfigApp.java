package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author: wuhui
 * @time: 2019/7/5 17:50
 * @desc:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class SpringCloudConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigApp.class, args);

    }
}
