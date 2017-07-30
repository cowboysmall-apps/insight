package com.cowboysmall.insight.demo.web;

import com.cowboysmall.insight.Level;
import com.cowboysmall.insight.Traceable;
import com.cowboysmall.insight.Profilable;
import com.cowboysmall.insight.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * jerry
 */

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;


    //_________________________________________________________________________

    @RequestMapping("/tracing")
    @ResponseBody
    @Traceable(Level.INFO)
    public String tracing() {

        return demoService.tracing("one", 2l);
    }

    @RequestMapping("/profiling")
    @ResponseBody
    @Profilable(Level.INFO)
    public String profiling() {

        return demoService.profiling("one", 2l);
    }
}
