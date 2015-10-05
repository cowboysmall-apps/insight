package com.cowboysmall.insight;

import com.cowboysmall.insight.mock.MockMessageService;
import com.cowboysmall.insight.service.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * jerry
 */

@Configuration
@ComponentScan(basePackages = {"com.cowboysmall.insight"})
@PropertySource("classpath:insight.properties")
@EnableAspectJAutoProxy
public class TestContextConfiguration {

    @Bean
    public MessageService messageService() {

        return new MockMessageService();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {

        return new PropertySourcesPlaceholderConfigurer();
    }
}
