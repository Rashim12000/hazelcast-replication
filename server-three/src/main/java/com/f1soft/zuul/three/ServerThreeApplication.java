package com.f1soft.zuul.three;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Rashim Dhaubanjar
 */
@ComponentScan(basePackages = {"com.f1soft"})
@EnableCaching
@SpringBootApplication(exclude = HazelcastAutoConfiguration.class)
public class ServerThreeApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ServerThreeApplication.class, args);
    }
}
