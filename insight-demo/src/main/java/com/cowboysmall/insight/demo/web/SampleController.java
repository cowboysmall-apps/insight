package com.cowboysmall.insight.demo.web;

import com.cowboysmall.insight.Loggable;
import com.cowboysmall.insight.LogLevel;
import com.cowboysmall.insight.Profilable;
import com.cowboysmall.insight.demo.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * jerry
 */

@RestController
public class SampleController {

    @Autowired
    private SampleService sampleService;


    //_________________________________________________________________________

    @RequestMapping("/logging")
    @ResponseBody
    @Loggable(LogLevel.INFO)
    public String logging() {

        return sampleService.logging("one", 2l);
    }

    @RequestMapping("/profiling")
    @ResponseBody
    @Profilable(LogLevel.INFO)
    public String profiling() {

        return sampleService.profiling("one", 2l);
    }
}
