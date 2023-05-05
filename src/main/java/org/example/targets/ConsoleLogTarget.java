package org.example.targets;

public class ConsoleLogTarget implements LogTarget{

    private int logLevel;
    @Override
    public void log(String message) {
        System.out.println(message);
    }

    @Override
    public void setLogLevel(int logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public int getLogLevel() {
        return this.logLevel;
    }
}