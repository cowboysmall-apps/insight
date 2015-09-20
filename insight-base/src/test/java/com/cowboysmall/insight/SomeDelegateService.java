package com.cowboysmall.insight;

import org.springframework.stereotype.Component;

/**
 * jerry
 */

@Component
public class SomeDelegateService {

    @Loggable(LogLevel.INFO)
    public void doSomethingElse(Object someOtherArg) {
    }

    @Loggable(LogLevel.INFO)
    public void throwsCheckedException(Object someOtherArg) throws Exception {

        throw new Exception("CheckedException");
    }

    @Loggable(LogLevel.INFO)
    public void throwsUncheckedException(Object someOtherArg) {

        throw new RuntimeException("UncheckedException");
    }
}
