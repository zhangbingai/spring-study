package com.bing.springcloud.controller;

import com.bing.springcloud.entity.CommonResult;
import com.bing.springcloud.entity.Payment;
import com.bing.springcloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bing.zhang
 * @Description:
 * @date 2020/6/17 17:48
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    DiscoveryClient discoveryClient;

    @Resource
    LoadBalance loadBalance;

    @PostMapping("consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getForEntityPaymentById(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping("consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        ServiceInstance serviceInstance = loadBalance.instances(instances);
        return restTemplate.getForObject(serviceInstance.getUri() + "payment/lb", String.class);
    }

}
