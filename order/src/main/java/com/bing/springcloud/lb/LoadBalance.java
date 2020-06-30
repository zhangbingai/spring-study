package com.bing.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author bing.zhang
 * @Description:
 * @date 2020/6/30 19:54
 */
public interface LoadBalance {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
