package com.cowboysmall.insight.object;

import com.cowboysmall.insight.Level;
import com.cowboysmall.insight.Traceable;
import org.springframework.stereotype.Component;

/**
 * jerry
 */

@Component
public class SomeDelegateService {

    @Traceable(Level.INFO)
    public void doSomethingElse(Object someOtherArg) {
    }

    @Traceable(Level.INFO)
    public void throwsCheckedException(Object someOtherArg) throws Exception {

        throw new Exception("CheckedException");
    }

    @Traceable(Level.INFO)
    public void throwsUncheckedException(Object someOtherArg) {

        throw new RuntimeException("UncheckedException");
    }
}
