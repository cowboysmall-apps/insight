package com.cowboysmall.insight.aspect;

import com.cowboysmall.insight.object.SomeService;
import com.cowboysmall.insight.TestContextConfiguration;
import com.cowboysmall.insight.mock.MockMessageService;
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
@ContextConfiguration(classes = TestContextConfiguration.class)
public class LoggingAspectTest {

    @Autowired
    private MockMessageService messageService;

    @Autowired
    private SomeService someService;


    //_________________________________________________________________________

    @Before
    public void setUp() {

        messageService.clear();
    }


    //_________________________________________________________________________

    @Test
    public void testInsightLoggingAspect_Basic() {

        someService.doSomething("something");

        assertEquals(2, messageService.getMessageList().size());

        assertEquals(
                "[ entering < doSomething > with args [something] ]",
                messageService.getMessageList().get(0));
        assertEquals(
                "[ leaving < doSomething > returning null ]",
                messageService.getMessageList().get(1));
    }

    @Test
    public void testInsightLoggingAspect_BasicWithReturn() {

        someService.doSomethingAndReturn("something");

        assertEquals(2, messageService.getMessageList().size());

        assertEquals(
                "[ entering < doSomethingAndReturn > with args [something] ]",
                messageService.getMessageList().get(0));
        assertEquals(
                "[ leaving < doSomethingAndReturn > returning SomeValue ]",
                messageService.getMessageList().get(1));
    }

    @Test
    public void testInsightLoggingAspect_BasicWithReturn_Array() {

        someService.doSomethingAndReturnArray("something");

        assertEquals(2, messageService.getMessageList().size());

        assertEquals(
                "[ entering < doSomethingAndReturnArray > with args [something] ]",
                messageService.getMessageList().get(0));
        assertEquals(
                "[ leaving < doSomethingAndReturnArray > returning [SomeValue, SomeOtherValue] ]",
                messageService.getMessageList().get(1));
    }

    @Test
    public void testInsightLoggingAspect_CheckedException() {

        try {

            someService.throwsCheckedException("something");

        } catch (Exception e) {

            // proceed
        }

        assertEquals(2, messageService.getMessageList().size());

        assertEquals(
                "[ entering < throwsCheckedException > with args [something] ]",
                messageService.getMessageList().get(0));
        assertEquals(
                "[ exception thrown by < throwsCheckedException > with args [something] with message CheckedException ]",
                messageService.getMessageList().get(1));
    }

    @Test
    public void testInsightLoggingAspect_UncheckedException() {

        try {

            someService.throwsUncheckedException("something");

        } catch (Exception e) {

            // proceed
        }

        assertEquals(2, messageService.getMessageList().size());

        assertEquals(
                "[ entering < throwsUncheckedException > with args [something] ]",
                messageService.getMessageList().get(0));
        assertEquals(
                "[ exception thrown by < throwsUncheckedException > with args [something] with message UncheckedException ]",
                messageService.getMessageList().get(1));
    }

    @Test
    public void testInsightLoggingAspect_CallDelegate() {

        someService.callDelegate("something");

        assertEquals(4, messageService.getMessageList().size());

        assertEquals(
                "[ entering < callDelegate > with args [something] ]",
                messageService.getMessageList().get(0));
        assertEquals(
                "[ entering < doSomethingElse > with args [something] ]",
                messageService.getMessageList().get(1));
        assertEquals(
                "[ leaving < doSomethingElse > returning null ]",
                messageService.getMessageList().get(2));
        assertEquals(
                "[ leaving < callDelegate > returning null ]",
                messageService.getMessageList().get(3));
    }

    @Test
    public void testInsightLoggingAspect_CallDelegate_CheckedException() {

        try {

            someService.callDelegateThrowsCheckedException("something");

        } catch (Exception e) {

            // proceed
        }

        assertEquals(4, messageService.getMessageList().size());
        assertEquals(1, messageService.getExceptionList().size());

        assertEquals(
                "[ entering < callDelegateThrowsCheckedException > with args [something] ]",
                messageService.getMessageList().get(0));
        assertEquals(
                "[ entering < throwsCheckedException > with args [something] ]",
                messageService.getMessageList().get(1));
        assertEquals(
                "[ exception thrown by < throwsCheckedException > with args [something] with message CheckedException ]",
                messageService.getMessageList().get(2));
        assertEquals(
                "[ exception thrown by < callDelegateThrowsCheckedException > with args [something] with message CheckedException ]",
                messageService.getMessageList().get(3));
    }

    @Test
    public void testInsightLoggingAspect_CallDelegate_UncheckedException() {

        try {

            someService.callDelegateThrowsUncheckedException("something");

        } catch (Exception e) {

            // proceed
        }

        assertEquals(4, messageService.getMessageList().size());
        assertEquals(1, messageService.getExceptionList().size());

        assertEquals(
                "[ entering < callDelegateThrowsUncheckedException > with args [something] ]",
                messageService.getMessageList().get(0));
        assertEquals(
                "[ entering < throwsUncheckedException > with args [something] ]",
                messageService.getMessageList().get(1));
        assertEquals(
                "[ exception thrown by < throwsUncheckedException > with args [something] with message UncheckedException ]",
                messageService.getMessageList().get(2));
        assertEquals(
                "[ exception thrown by < callDelegateThrowsUncheckedException > with args [something] with message UncheckedException ]",
                messageService.getMessageList().get(3));
    }

    @Test
    public void testInsightLoggingAspect_CallDelegate_RethrownUncheckedException() {

        try {

            someService.callDelegateThrowsUncheckedExceptionAndRethrows("something");

        } catch (Exception e) {

            // proceed
        }

        assertEquals(4, messageService.getMessageList().size());
        assertEquals(1, messageService.getExceptionList().size());

        assertEquals(
                "[ entering < callDelegateThrowsUncheckedExceptionAndRethrows > with args [something] ]",
                messageService.getMessageList().get(0));
        assertEquals(
                "[ entering < throwsUncheckedException > with args [something] ]",
                messageService.getMessageList().get(1));
        assertEquals(
                "[ exception thrown by < throwsUncheckedException > with args [something] with message UncheckedException ]",
                messageService.getMessageList().get(2));
        assertEquals(
                "[ exception thrown by < callDelegateThrowsUncheckedExceptionAndRethrows > with args [something] with message UncheckedException ]",
                messageService.getMessageList().get(3));
    }
}
