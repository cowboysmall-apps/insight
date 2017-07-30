package com.cowboysmall.insight.demo.service;

/**
 * jerry
 * 9/19/15
 */
public interface DemoService {

    String tracing(String value1, Long value2);

    String profiling(String value1, Long value2);

    void scheduled(String value1, Long value2);
}
