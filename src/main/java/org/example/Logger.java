package org.example;

import org.example.targets.LogTarget;

import java.util.ArrayList;
import java.util.List;

public class Logger {

    private int logLevel;
    private List<LogTarget> targets;

    public static final int DEBUG = 0;
    public static final int INFO = 1;
    public static final int WARNING = 2;
    public static final int ERROR = 3;

    public Logger(int logLevel) {
        this.logLevel = logLevel;
        this.targets = new ArrayList<>();
    }

    public void addTarget(LogTarget target) {
        targets.add(target);
    }

    public void debug(String message) {
        if (logLevel <= DEBUG) {
            log("[DEBUG] " + message);
        }
    }

    public void info(String message) {
        if (logLevel <= INFO) {
            log("[INFO] " + message);
        }
    }

    public void warning(String message) {
        if (logLevel <= WARNING) {
            log("[WARNING] " + message);
        }
    }

    public void error(String message) {
        if (logLevel <= ERROR) {
            log("[ERROR] " + message);
        }
    }

    private void log(String message) {
        for (LogTarget target : targets) {
            if (this.logLevel >= target.getLogLevel()) {
                target.log(message);
            }
        }
    }

    public void setLogLevel(int logLevel) {
        this.logLevel = logLevel;
    }

}