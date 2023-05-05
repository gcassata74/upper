package org.example;


import org.example.targets.ConsoleLogTarget;
import org.example.targets.FileLogTarget;

public class Main {
    public static void main(String[] args) {

        Logger logger = new Logger(Logger.DEBUG);
        ConsoleLogTarget consoleTarget = new ConsoleLogTarget();
        consoleTarget.setLogLevel(Logger.DEBUG);
        FileLogTarget fileTarget = new FileLogTarget("log.txt");
        fileTarget.setLogLevel(Logger.DEBUG);
        logger.addTarget(consoleTarget);
        logger.addTarget(fileTarget);
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warning("This is a warning message");
        logger.error("This is an error message");

    }
}