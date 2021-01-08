package com.f1soft.zuul.proxy.two;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Map;

/**
 * @author Rashim Dhaubanjar
 */
@EntityScan(basePackages = {"com.f1soft"})
@ComponentScan(basePackages = {"com.f1soft"})
@EnableJpaRepositories(basePackages = {"com.f1soft"})
@EnableCaching
@SpringBootApplication(exclude = HazelcastAutoConfiguration.class)
public class ServerTwoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ServerTwoApplication.class, args);
    }
}
