package com.ldx.provider7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Provider7001Application {
    public static void main(String[] args) {
        SpringApplication.run(Provider7001Application.class, args);
    }
}
