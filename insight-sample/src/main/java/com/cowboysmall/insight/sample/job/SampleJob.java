package com.cowboysmall.insight.sample.job;

import com.cowboysmall.insight.sample.service.SampleService;
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
    public void execute() {

        sampleService.scheduled();
    }
}
