package de.tech26.robotfactory.robotfactory.logging;

import java.util.logging.Logger;

public class AppLogger {

  public static Logger logger;

  static {
    logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
  }
}
