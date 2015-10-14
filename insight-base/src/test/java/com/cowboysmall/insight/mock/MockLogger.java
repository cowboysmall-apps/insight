package com.cowboysmall.insight.mock;

import org.slf4j.Logger;
import org.slf4j.Marker;

/**
 * jerry
 */

public class MockLogger implements Logger {

    public boolean raiseException = false;

    public boolean traceCalled = false;
    public boolean debugCalled = false;
    public boolean infoCalled = false;
    public boolean warnCalled = false;
    public boolean errorCalled = false;

    public String message;
    public Throwable throwable;

    @Override
    public void trace(String msg) {

        traceCalled = true;

        if (raiseException)
            throw new RuntimeException("Exception Raised");

        message = msg;
    }

    @Override
    public void trace(String msg, Throwable t) {

        traceCalled = true;

        if (raiseException)
            throw new RuntimeException("Exception Raised");

        message = msg;
        throwable = t;
    }

    @Override
    public void debug(String msg) {

        debugCalled = true;

        if (raiseException)
            throw new RuntimeException("Exception Raised");

        message = msg;
    }

    @Override
    public void debug(String msg, Throwable t) {

        debugCalled = true;

        if (raiseException)
            throw new RuntimeException("Exception Raised");

        message = msg;
        throwable = t;
    }

    @Override
    public void info(String msg) {

        infoCalled = true;

        if (raiseException)
            throw new RuntimeException("Exception Raised");

        message = msg;
    }

    @Override
    public void info(String msg, Throwable t) {

        infoCalled = true;

        if (raiseException)
            throw new RuntimeException("Exception Raised");

        message = msg;
        throwable = t;
    }

    @Override
    public void warn(String msg) {

        warnCalled = true;

        if (raiseException)
            throw new RuntimeException("Exception Raised");

        message = msg;
    }

    @Override
    public void warn(String msg, Throwable t) {

        warnCalled = true;

        if (raiseException)
            throw new RuntimeException("Exception Raised");

        message = msg;
        throwable = t;
    }

    @Override
    public void error(String msg) {

        errorCalled = true;

        if (raiseException)
            throw new RuntimeException("Exception Raised");

        message = msg;
    }

    @Override
    public void error(String msg, Throwable t) {

        errorCalled = true;

        if (raiseException)
            throw new RuntimeException("Exception Raised");

        message = msg;
        throwable = t;
    }




    //_________________________________________________________________________

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public void trace(String format, Object arg) {

    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {

    }

    @Override
    public void trace(String format, Object... arguments) {

    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return false;
    }

    @Override
    public void trace(Marker marker, String msg) {

    }

    @Override
    public void trace(Marker marker, String format, Object arg) {

    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {

    }

    @Override
    public void trace(Marker marker, String format, Object... argArray) {

    }

    @Override
    public void trace(Marker marker, String msg, Throwable t) {

    }

    @Override
    public boolean isDebugEnabled() {
        return false;
    }

    @Override
    public void debug(String format, Object arg) {

    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {

    }

    @Override
    public void debug(String format, Object... arguments) {

    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return false;
    }

    @Override
    public void debug(Marker marker, String msg) {

    }

    @Override
    public void debug(Marker marker, String format, Object arg) {

    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {

    }

    @Override
    public void debug(Marker marker, String format, Object... arguments) {

    }

    @Override
    public void debug(Marker marker, String msg, Throwable t) {

    }

    @Override
    public boolean isInfoEnabled() {
        return false;
    }

    @Override
    public void info(String format, Object arg) {

    }

    @Override
    public void info(String format, Object arg1, Object arg2) {

    }

    @Override
    public void info(String format, Object... arguments) {

    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return false;
    }

    @Override
    public void info(Marker marker, String msg) {

    }

    @Override
    public void info(Marker marker, String format, Object arg) {

    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {

    }

    @Override
    public void info(Marker marker, String format, Object... arguments) {

    }

    @Override
    public void info(Marker marker, String msg, Throwable t) {

    }

    @Override
    public boolean isWarnEnabled() {
        return false;
    }

    @Override
    public void warn(String format, Object arg) {

    }

    @Override
    public void warn(String format, Object... arguments) {

    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {

    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return false;
    }

    @Override
    public void warn(Marker marker, String msg) {

    }

    @Override
    public void warn(Marker marker, String format, Object arg) {

    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {

    }

    @Override
    public void warn(Marker marker, String format, Object... arguments) {

    }

    @Override
    public void warn(Marker marker, String msg, Throwable t) {

    }

    @Override
    public boolean isErrorEnabled() {
        return false;
    }

    @Override
    public void error(String format, Object arg) {

    }

    @Override
    public void error(String format, Object arg1, Object arg2) {

    }

    @Override
    public void error(String format, Object... arguments) {

    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return false;
    }

    @Override
    public void error(Marker marker, String msg) {

    }

    @Override
    public void error(Marker marker, String format, Object arg) {

    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {

    }

    @Override
    public void error(Marker marker, String format, Object... arguments) {

    }

    @Override
    public void error(Marker marker, String msg, Throwable t) {

    }
}
