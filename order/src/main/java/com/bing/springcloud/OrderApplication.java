package com.bing.springcloud;

import com.bing.rule.Rule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @author bing.zhang
 * @Description: 启动类
 * @date 2020/6/17 10:27
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "PAYMENT-SERVICE", configuration = Rule.class)
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
