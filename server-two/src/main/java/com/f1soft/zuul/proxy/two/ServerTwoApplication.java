package com.f1soft.zuul.proxy.two;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Rashim Dhaubanjar
 */
@EntityScan(basePackages = {"com.f1soft"})
@ComponentScan(basePackages = {"com.f1soft"})
@EnableJpaRepositories(basePackages = {"com.f1soft"})
@EnableCaching
@SpringBootApplication(scanBasePackages = {"com.f1soft"})
public class ServerTwoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ServerTwoApplication.class, args);
    }
}
