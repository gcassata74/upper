package org.example.targets;

public interface LogTarget {

    public void log(String message);
    void setLogLevel(int logLevel);
    int getLogLevel();
}