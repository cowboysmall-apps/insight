package com.cowboysmall.insight;

import com.cowboysmall.insight.service.MessageService;
import com.cowboysmall.insight.service.MockMessageService;
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
    public MessageService messageService() {

        return new MockMessageService();
    }
}
