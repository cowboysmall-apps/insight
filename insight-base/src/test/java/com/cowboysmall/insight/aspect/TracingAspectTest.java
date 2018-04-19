package com.cowboysmall.insight.aspect;

import com.cowboysmall.insight.TestContext;
import com.cowboysmall.insight.mock.MockLoggerService;
import com.cowboysmall.insight.object.SomeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * jerry
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestContext.class)
public class TracingAspectTest {

    @Autowired
    private MockLoggerService logMessageService;

    @Autowired
    private SomeService someService;


    //_________________________________________________________________________

    @Before
    public void setUp() {

        logMessageService.clear();
    }


    //_________________________________________________________________________

    @Test
    public void testInsightLoggingAspect_Basic() {

        someService.doSomething("something");

        assertEquals(2, logMessageService.getMessageList().size());

        assertEquals(
                "entering < doSomething > with args [something]",
                logMessageService.getMessageList().get(0));
        assertEquals(
                "leaving < doSomething > returning null",
                logMessageService.getMessageList().get(1));
    }

    @Test
    public void testInsightLoggingAspect_BasicWithReturn() {

        someService.doSomethingAndReturn("something");

        assertEquals(2, logMessageService.getMessageList().size());

        assertEquals(
                "entering < doSomethingAndReturn > with args [something]",
                logMessageService.getMessageList().get(0));
        assertEquals(
                "leaving < doSomethingAndReturn > returning SomeValue",
                logMessageService.getMessageList().get(1));
    }

    @Test
    public void testInsightLoggingAspect_BasicWithReturn_Array() {

        someService.doSomethingAndReturnArray("something");

        assertEquals(2, logMessageService.getMessageList().size());

        assertEquals(
                "entering < doSomethingAndReturnArray > with args [something]",
                logMessageService.getMessageList().get(0));
        assertEquals(
                "leaving < doSomethingAndReturnArray > returning [SomeValue, SomeOtherValue]",
                logMessageService.getMessageList().get(1));
    }

    @Test
    public void testInsightLoggingAspect_CheckedException() {

        try {

            someService.throwsCheckedException("something");

        } catch (Exception e) {

            // proceed
        }

        assertEquals(2, logMessageService.getMessageList().size());

        assertEquals(
                "entering < throwsCheckedException > with args [something]",
                logMessageService.getMessageList().get(0));
        assertEquals(
                "exception thrown by < throwsCheckedException > with args [something] with message 'CheckedException'",
                logMessageService.getMessageList().get(1));
    }

    @Test
    public void testInsightLoggingAspect_UncheckedException() {

        try {

            someService.throwsUncheckedException("something");

        } catch (Exception e) {

            // proceed
        }

        assertEquals(2, logMessageService.getMessageList().size());

        assertEquals(
                "entering < throwsUncheckedException > with args [something]",
                logMessageService.getMessageList().get(0));
        assertEquals(
                "exception thrown by < throwsUncheckedException > with args [something] with message 'UncheckedException'",
                logMessageService.getMessageList().get(1));
    }

    @Test
    public void testInsightLoggingAspect_CallDelegate() {

        someService.callDelegate("something");

        assertEquals(4, logMessageService.getMessageList().size());

        assertEquals(
                "entering < callDelegate > with args [something]",
                logMessageService.getMessageList().get(0));
        assertEquals(
                "entering < doSomethingElse > with args [something]",
                logMessageService.getMessageList().get(1));
        assertEquals(
                "leaving < doSomethingElse > returning null",
                logMessageService.getMessageList().get(2));
        assertEquals(
                "leaving < callDelegate > returning null",
                logMessageService.getMessageList().get(3));
    }

    @Test
    public void testInsightLoggingAspect_CallDelegate_CheckedException() {

        try {

            someService.callDelegateThrowsCheckedException("something");

        } catch (Exception e) {

            // proceed
        }

        assertEquals(4, logMessageService.getMessageList().size());
        assertEquals(1, logMessageService.getExceptionList().size());

        assertEquals(
                "entering < callDelegateThrowsCheckedException > with args [something]",
                logMessageService.getMessageList().get(0));
        assertEquals(
                "entering < throwsCheckedException > with args [something]",
                logMessageService.getMessageList().get(1));
        assertEquals(
                "exception thrown by < throwsCheckedException > with args [something] with message 'CheckedException'",
                logMessageService.getMessageList().get(2));
        assertEquals(
                "exception thrown by < callDelegateThrowsCheckedException > with args [something] with message 'CheckedException'",
                logMessageService.getMessageList().get(3));
    }

    @Test
    public void testInsightLoggingAspect_CallDelegate_UncheckedException() {

        try {

            someService.callDelegateThrowsUncheckedException("something");

        } catch (Exception e) {

            // proceed
        }

        assertEquals(4, logMessageService.getMessageList().size());
        assertEquals(1, logMessageService.getExceptionList().size());

        assertEquals(
                "entering < callDelegateThrowsUncheckedException > with args [something]",
                logMessageService.getMessageList().get(0));
        assertEquals(
                "entering < throwsUncheckedException > with args [something]",
                logMessageService.getMessageList().get(1));
        assertEquals(
                "exception thrown by < throwsUncheckedException > with args [something] with message 'UncheckedException'",
                logMessageService.getMessageList().get(2));
        assertEquals(
                "exception thrown by < callDelegateThrowsUncheckedException > with args [something] with message 'UncheckedException'",
                logMessageService.getMessageList().get(3));
    }

    @Test
    public void testInsightLoggingAspect_CallDelegate_RethrownUncheckedException() {

        try {

            someService.callDelegateThrowsUncheckedExceptionAndRethrows("something");

        } catch (Exception e) {

            // proceed
        }

        assertEquals(4, logMessageService.getMessageList().size());
        assertEquals(1, logMessageService.getExceptionList().size());

        assertEquals(
                "entering < callDelegateThrowsUncheckedExceptionAndRethrows > with args [something]",
                logMessageService.getMessageList().get(0));
        assertEquals(
                "entering < throwsUncheckedException > with args [something]",
                logMessageService.getMessageList().get(1));
        assertEquals(
                "exception thrown by < throwsUncheckedException > with args [something] with message 'UncheckedException'",
                logMessageService.getMessageList().get(2));
        assertEquals(
                "exception thrown by < callDelegateThrowsUncheckedExceptionAndRethrows > with args [something] with message 'UncheckedException'",
                logMessageService.getMessageList().get(3));
    }
}
