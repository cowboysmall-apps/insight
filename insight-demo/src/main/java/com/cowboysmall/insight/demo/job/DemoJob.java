package com.cowboysmall.insight.demo.job;

import com.cowboysmall.insight.LogLevel;
import com.cowboysmall.insight.Loggable;
import com.cowboysmall.insight.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * jerry
 */

@Component
public class DemoJob {

    @Autowired
    private DemoService demoService;


    //_________________________________________________________________________

    @Scheduled(cron = "*/5 * * * * *")
    @Loggable(LogLevel.INFO)
    public void execute() {

        demoService.scheduled("one", 2l);
    }
}
