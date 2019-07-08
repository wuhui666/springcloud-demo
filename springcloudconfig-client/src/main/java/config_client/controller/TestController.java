package config_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wuhui
 * @time: 2019/7/5 21:12
 * @desc:
 */
@RestController
@RefreshScope
public class TestController {

    @Value(value = "${flag}")
    public String flag;

    @GetMapping("/flag")
    public String test(){
        return "flag = "+flag;
    }
}
