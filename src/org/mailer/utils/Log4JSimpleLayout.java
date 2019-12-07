package org.mailer.utils;

import org.apache.log4j.spi.LoggingEvent;
public class Log4JSimpleLayout extends org.apache.log4j.Layout {
    @Override
    public String format(LoggingEvent event) {
        return "log message = " + event.getMessage().toString() + "\n";
    }
    @Override
    public boolean ignoresThrowable() {
        return true;
    }
    public void activateOptions() {
    }
}