package com.bing.springcloud.service.impl;

import com.bing.springcloud.dao.PaymentDao;
import com.bing.springcloud.entity.Payment;
import com.bing.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author bing.zhang
 * @Description:
 * @date 2020/6/17 11:41
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
