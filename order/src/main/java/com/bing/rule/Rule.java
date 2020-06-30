package com.bing.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bing.zhang
 * @Description:
 * @date 2020/6/28 15:07
 */
@Configuration
public class Rule {

    @Bean
    public IRule myRule() {
        return new RandomRule();
    }

}
