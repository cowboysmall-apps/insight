package com.cowboysmall.insight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * jerry
 */

@Component
public class SomeService {

    @Autowired
    private SomeDelegateService someDelegateService;

    @Loggable(LogLevel.INFO)
    public void doSomething(Object someArg) {
    }

    @Loggable(LogLevel.INFO)
    public Object doSomethingAndReturn(Object someArg) {

        return "SomeValue";
    }

    @Loggable(LogLevel.INFO)
    public Object doSomethingAndReturnArray(Object someArg) {

        return new String[]{"SomeValue", "SomeOtherValue"};
    }

    @Loggable(LogLevel.INFO)
    public void throwsCheckedException(Object someArg) throws Exception {

        throw new Exception("CheckedException");
    }

    @Loggable(LogLevel.INFO)
    public void throwsUncheckedException(Object someArg) {

        throw new RuntimeException("UncheckedException");
    }

    @Loggable(LogLevel.INFO)
    public void callDelegate(Object someArg) {

        someDelegateService.doSomethingElse(someArg);
    }

    @Loggable(LogLevel.INFO)
    public void callDelegateThrowsCheckedException(Object someArg) throws Exception {

        someDelegateService.throwsCheckedException(someArg);
    }

    @Loggable(LogLevel.INFO)
    public void callDelegateThrowsUncheckedException(Object someArg) {

        someDelegateService.throwsUncheckedException(someArg);
    }

    @Loggable(LogLevel.INFO)
    public void callDelegateThrowsUncheckedExceptionAndRethrows(Object someArg) {

        try {

            someDelegateService.throwsUncheckedException(someArg);

        } catch (Exception e) {

            throw new RuntimeException("UncheckedException", e);
        }
    }
}
