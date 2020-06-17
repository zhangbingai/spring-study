package com.bing.springcloud.service;

import com.bing.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author bing.zhang
 * @Description:
 * @date 2020/6/17 11:40
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
