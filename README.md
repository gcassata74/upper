# Logging Library

The Logging Library is a Java library for logging messages to different targets, such as the console or a file. The library provides a flexible and extensible way to log messages at different levels of detail.

## Features

- Logs messages to different targets, such as the console or a file.
- Supports different logging levels, including `DEBUG`, `INFO`, `WARNING`, and `ERROR`.
- Provides an extensible architecture for adding new log targets and customizing logging behavior.

## Getting Started

To use the Logging Library in your Java project, follow these steps:

1. Download the latest release of the Logging Library from the [GitHub releases page](https://github.com/yourusername/logging-library/releases).
2. Add the Logging Library JAR file to your project's classpath.
3. Create a `Logger` instance with the desired logging level, and add one or more `LogTarget` objects to it.
4. Use the `debug`, `info`, `warning`, and `error` methods of the `Logger` instance to log messages at different levels of detail.

```java
import org.example.Logger;
import org.example.targets.ConsoleLogTarget;
import org.example.targets.FileLogTarget;

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
```

## Contributing

1. Fork the repository on GitHub.
2. Create a new branch for your changes.
3. Make your changes and commit them with clear commit messages.
4. Submit a pull request.
