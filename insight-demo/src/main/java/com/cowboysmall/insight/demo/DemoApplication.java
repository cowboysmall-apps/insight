package com.cowboysmall.insight.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * jerry
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.cowboysmall.insight"})
@PropertySource("classpath:insight.properties")
@EnableAspectJAutoProxy
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(DemoApplication.class, args);
    }
}
