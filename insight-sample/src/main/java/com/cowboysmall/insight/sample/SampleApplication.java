package com.cowboysmall.insight.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * jerry
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.cowboysmall.insight"})
@EnableAspectJAutoProxy
@EnableScheduling
public class SampleApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(SampleApplication.class, args);
    }
}
