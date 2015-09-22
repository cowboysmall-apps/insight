package com.cowboysmall.insight.demo.job;

import com.cowboysmall.insight.LogLevel;
import com.cowboysmall.insight.Loggable;
import com.cowboysmall.insight.demo.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * jerry
 */

@Component
public class SampleJob {

    @Autowired
    private SampleService sampleService;


    //_________________________________________________________________________

    @Scheduled(cron = "*/5 * * * * *")
    @Loggable(LogLevel.INFO)
    public void execute() {

        sampleService.scheduled("one", 2l);
    }
}
