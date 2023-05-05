package org.example.targets;

public class FileLogTarget implements LogTarget{

    private String filename;

    public FileLogTarget(String filename) {
        this.filename = filename;
    }

    private int logLevel;
    @Override
    public void log(String message) {
        // write message to file
        System.out.println(String.format("I'm writing %s on this file: %s",message, filename));
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


