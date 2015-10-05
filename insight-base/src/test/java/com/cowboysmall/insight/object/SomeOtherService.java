package com.cowboysmall.insight.object;

import com.cowboysmall.insight.LogLevel;
import com.cowboysmall.insight.Profilable;
import org.springframework.stereotype.Component;

/**
 * jerry
 */

@Component
public class SomeOtherService {

    @Profilable(LogLevel.INFO)
    public void doSomething() {

    }

    @Profilable(LogLevel.INFO)
    public void doSomethingWithArgs(String first, Long second) {

    }

    @Profilable(LogLevel.INFO)
    public Integer doSomethingWithReturn() {

        return Integer.MAX_VALUE;
    }

    @Profilable(LogLevel.INFO)
    public Integer doSomethingWithArgsAndReturn(String first, Long second, Double third) {

        return Integer.MIN_VALUE;
    }
}
