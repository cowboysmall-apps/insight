package com.cowboysmall.insight;

import com.cowboysmall.insight.mock.MockLoggerService;
import com.cowboysmall.insight.service.LoggerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * jerry
 */

@Configuration
@ComponentScan(basePackages = {"com.cowboysmall.insight"})
@EnableAspectJAutoProxy
public class TestContextConfiguration {

    @Bean
    public LoggerService loggerService() {

        return new MockLoggerService();
    }
}
