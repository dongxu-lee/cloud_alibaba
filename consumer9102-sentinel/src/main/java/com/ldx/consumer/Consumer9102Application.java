package com.ldx.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class Consumer9102Application {
    public static void main(String[] args) {
        SpringApplication.run(Consumer9102Application.class, args);
    }

    /**
     * 这里的@LoadBalanced必不可少，因为需要它来根据服务名选择某台服务器，并获取uri
     * @return
     */
    @LoadBalanced
    @Bean(name = "restTemplate9102")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
