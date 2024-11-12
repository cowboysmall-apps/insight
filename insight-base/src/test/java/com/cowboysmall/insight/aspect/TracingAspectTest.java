package com.cowboysmall.insight.aspect;

import com.cowboysmall.insight.TestContext;
import com.cowboysmall.insight.mock.MockLoggerService;
import com.cowboysmall.insight.object.SomeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * jerry
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestContext.class)
public class TracingAspectTest {

    @Autowired
    private MockLoggerService loggerService;

    @Autowired
    private SomeService someService;


    //_________________________________________________________________________

    @BeforeEach
    public void setUp() {

        loggerService.clear();
    }


    //_________________________________________________________________________

    @Test
    public void testInsightLoggingAspect_Basic() {

        someService.doSomething("something");

        assertEquals(2, loggerService.getMessageList().size());

        assertEquals(1, loggerService.getLevels().size());
        assertEquals(1, loggerService.getClasses().size());
        assertEquals(
                "entering < doSomething > with args [something]",
                loggerService.getMessageList().get(0));
        assertEquals(
                "leaving < doSomething > returning null",
                loggerService.getMessageList().get(1));
    }

    @Test
    public void testInsightLoggingAspect_BasicWithReturn() {

        someService.doSomethingAndReturn("something");

        assertEquals(2, loggerService.getMessageList().size());

        assertEquals(1, loggerService.getLevels().size());
        assertEquals(1, loggerService.getClasses().size());
        assertEquals(
                "entering < doSomethingAndReturn > with args [something]",
                loggerService.getMessageList().get(0));
        assertEquals(
                "leaving < doSomethingAndReturn > returning SomeValue",
                loggerService.getMessageList().get(1));
    }

    @Test
    public void testInsightLoggingAspect_BasicWithReturn_Array() {

        someService.doSomethingAndReturnArray("something");

        assertEquals(2, loggerService.getMessageList().size());

        assertEquals(1, loggerService.getLevels().size());
        assertEquals(1, loggerService.getClasses().size());
        assertEquals(
                "entering < doSomethingAndReturnArray > with args [something]",
                loggerService.getMessageList().get(0));
        assertEquals(
                "leaving < doSomethingAndReturnArray > returning [SomeValue, SomeOtherValue]",
                loggerService.getMessageList().get(1));
    }

    @Test
    public void testInsightLoggingAspect_CheckedException() {

        try {

            someService.throwsCheckedException("something");

        } catch (Exception e) {

            // proceed
        }

        assertEquals(2, loggerService.getMessageList().size());

        assertEquals(1, loggerService.getLevels().size());
        assertEquals(1, loggerService.getClasses().size());
        assertEquals(
                "entering < throwsCheckedException > with args [something]",
                loggerService.getMessageList().get(0));
        assertEquals(
                "exception thrown by < throwsCheckedException > with args [something] with message 'CheckedException'",
                loggerService.getMessageList().get(1));
    }

    @Test
    public void testInsightLoggingAspect_UncheckedException() {

        try {

            someService.throwsUncheckedException("something");

        } catch (Exception e) {

            // proceed
        }

        assertEquals(2, loggerService.getMessageList().size());

        assertEquals(1, loggerService.getLevels().size());
        assertEquals(1, loggerService.getClasses().size());
        assertEquals(
                "entering < throwsUncheckedException > with args [something]",
                loggerService.getMessageList().get(0));
        assertEquals(
                "exception thrown by < throwsUncheckedException > with args [something] with message 'UncheckedException'",
                loggerService.getMessageList().get(1));
    }

    @Test
    public void testInsightLoggingAspect_CallDelegate() {

        someService.callDelegate("something");

        assertEquals(4, loggerService.getMessageList().size());

        assertEquals(1, loggerService.getLevels().size());
        assertEquals(2, loggerService.getClasses().size());
        assertEquals(
                "entering < callDelegate > with args [something]",
                loggerService.getMessageList().get(0));
        assertEquals(
                "entering < doSomethingElse > with args [something]",
                loggerService.getMessageList().get(1));
        assertEquals(
                "leaving < doSomethingElse > returning null",
                loggerService.getMessageList().get(2));
        assertEquals(
                "leaving < callDelegate > returning null",
                loggerService.getMessageList().get(3));
    }

    @Test
    public void testInsightLoggingAspect_CallDelegate_CheckedException() {

        try {

            someService.callDelegateThrowsCheckedException("something");

        } catch (Exception e) {

            // proceed
        }

        assertEquals(4, loggerService.getMessageList().size());
        assertEquals(1, loggerService.getExceptionList().size());

        assertEquals(1, loggerService.getLevels().size());
        assertEquals(2, loggerService.getClasses().size());
        assertEquals(
                "entering < callDelegateThrowsCheckedException > with args [something]",
                loggerService.getMessageList().get(0));
        assertEquals(
                "entering < throwsCheckedException > with args [something]",
                loggerService.getMessageList().get(1));
        assertEquals(
                "exception thrown by < throwsCheckedException > with args [something] with message 'CheckedException'",
                loggerService.getMessageList().get(2));
        assertEquals(
                "exception thrown by < callDelegateThrowsCheckedException > with args [something] with message 'CheckedException'",
                loggerService.getMessageList().get(3));
    }

    @Test
    public void testInsightLoggingAspect_CallDelegate_UncheckedException() {

        try {

            someService.callDelegateThrowsUncheckedException("something");

        } catch (Exception e) {

            // proceed
        }

        assertEquals(4, loggerService.getMessageList().size());
        assertEquals(1, loggerService.getExceptionList().size());

        assertEquals(1, loggerService.getLevels().size());
        assertEquals(2, loggerService.getClasses().size());
        assertEquals(
                "entering < callDelegateThrowsUncheckedException > with args [something]",
                loggerService.getMessageList().get(0));
        assertEquals(
                "entering < throwsUncheckedException > with args [something]",
                loggerService.getMessageList().get(1));
        assertEquals(
                "exception thrown by < throwsUncheckedException > with args [something] with message 'UncheckedException'",
                loggerService.getMessageList().get(2));
        assertEquals(
                "exception thrown by < callDelegateThrowsUncheckedException > with args [something] with message 'UncheckedException'",
                loggerService.getMessageList().get(3));
    }

    @Test
    public void testInsightLoggingAspect_CallDelegate_RethrownUncheckedException() {

        try {

            someService.callDelegateThrowsUncheckedExceptionAndRethrows("something");

        } catch (Exception e) {

            // proceed
        }

        assertEquals(4, loggerService.getMessageList().size());
        assertEquals(1, loggerService.getExceptionList().size());

        assertEquals(1, loggerService.getLevels().size());
        assertEquals(2, loggerService.getClasses().size());
        assertEquals(
                "entering < callDelegateThrowsUncheckedExceptionAndRethrows > with args [something]",
                loggerService.getMessageList().get(0));
        assertEquals(
                "entering < throwsUncheckedException > with args [something]",
                loggerService.getMessageList().get(1));
        assertEquals(
                "exception thrown by < throwsUncheckedException > with args [something] with message 'UncheckedException'",
                loggerService.getMessageList().get(2));
        assertEquals(
                "exception thrown by < callDelegateThrowsUncheckedExceptionAndRethrows > with args [something] with message 'UncheckedException'",
                loggerService.getMessageList().get(3));
    }
}
