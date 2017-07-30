package com.cowboysmall.insight.object;

import com.cowboysmall.insight.Level;
import com.cowboysmall.insight.Profilable;
import org.springframework.stereotype.Component;

/**
 * jerry
 */

@Component
public class SomeOtherService {

    @Profilable(Level.INFO)
    public void doSomething() {

    }

    @Profilable(Level.INFO)
    public void doSomethingWithArgs(String first, Long second) {

    }

    @Profilable(Level.INFO)
    public Integer doSomethingWithReturn() {

        return Integer.MAX_VALUE;
    }

    @Profilable(Level.INFO)
    public Integer doSomethingWithArgsAndReturn(String first, Long second, Double third) {

        return Integer.MIN_VALUE;
    }
}
