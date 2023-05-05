package org.example;

import org.example.Logger;
import org.example.targets.LogTarget;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class LoggerTest {

    private Logger logger;
    private LogTarget target;

    @Before
    public void setUp() {
        logger = new Logger(Logger.DEBUG);
        target = mock(LogTarget.class);
        logger.addTarget(target);
    }

    @Test
    public void testDebugMessageLogged() {
        logger.debug("Debug message");
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        verify(target).log(argument.capture());
        assertEquals("[DEBUG] Debug message", argument.getValue());
    }

    @Test
    public void testInfoMessageLogged() {
        logger.info("Info message");
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        verify(target).log(argument.capture());
        assertEquals("[INFO] Info message", argument.getValue());
    }

    @Test
    public void testWarningMessageLogged() {
        logger.warning("Warning message");
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        verify(target).log(argument.capture());
        assertEquals("[WARNING] Warning message", argument.getValue());
    }

    @Test
    public void testErrorMessageLogged() {
        logger.error("Error message");
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        verify(target).log(argument.capture());
        assertEquals("[ERROR] Error message", argument.getValue());
    }

    @Test
    public void testDebugMessageNotLogged() {
        logger.setLogLevel(Logger.INFO);
        logger.debug("Debug message");
        verify(target, Mockito.never()).log(Mockito.anyString());
    }

    @Test
    public void testInfoMessageNotLogged() {
        logger.setLogLevel(Logger.WARNING);
        logger.info("Info message");
        verify(target, Mockito.never()).log(Mockito.anyString());
    }

    @Test
    public void testWarningMessageNotLogged() {
        logger.setLogLevel(Logger.ERROR);
        logger.warning("Warning message");
        verify(target, Mockito.never()).log(Mockito.anyString());
    }

    @Test
    public void testErrorMessageAlwaysLogged() {
        logger.setLogLevel(Logger.WARNING);
        logger.error("Error message");
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        verify(target).log(argument.capture());
        assertEquals("[ERROR] Error message", argument.getValue());
    }

}
