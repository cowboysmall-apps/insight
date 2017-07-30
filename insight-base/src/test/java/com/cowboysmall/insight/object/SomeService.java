package com.cowboysmall.insight.object;

import com.cowboysmall.insight.Level;
import com.cowboysmall.insight.Traceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * jerry
 */

@Component
public class SomeService {

    @Autowired
    private SomeDelegateService someDelegateService;

    @Traceable(Level.INFO)
    public void doSomething(Object someArg) {
    }

    @Traceable(Level.INFO)
    public Object doSomethingAndReturn(Object someArg) {

        return "SomeValue";
    }

    @Traceable(Level.INFO)
    public Object doSomethingAndReturnArray(Object someArg) {

        return new String[]{"SomeValue", "SomeOtherValue"};
    }

    @Traceable(Level.INFO)
    public void throwsCheckedException(Object someArg) throws Exception {

        throw new Exception("CheckedException");
    }

    @Traceable(Level.INFO)
    public void throwsUncheckedException(Object someArg) {

        throw new RuntimeException("UncheckedException");
    }

    @Traceable(Level.INFO)
    public void callDelegate(Object someArg) {

        someDelegateService.doSomethingElse(someArg);
    }

    @Traceable(Level.INFO)
    public void callDelegateThrowsCheckedException(Object someArg) throws Exception {

        someDelegateService.throwsCheckedException(someArg);
    }

    @Traceable(Level.INFO)
    public void callDelegateThrowsUncheckedException(Object someArg) {

        someDelegateService.throwsUncheckedException(someArg);
    }

    @Traceable(Level.INFO)
    public void callDelegateThrowsUncheckedExceptionAndRethrows(Object someArg) {

        try {

            someDelegateService.throwsUncheckedException(someArg);

        } catch (Exception e) {

            throw new RuntimeException("UncheckedException", e);
        }
    }
}
