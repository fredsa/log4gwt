package com.allen_sauer.gwt.log4gwt.demo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;

import com.allen_sauer.gwt.log.client.Log;

import org.apache.log4j.Logger;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Log4gwtDemo implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    // set uncaught exception handler
    Log.setUncaughtExceptionHandler();

    // use deferred command to catch initialization exceptions
    DeferredCommand.addCommand(new Command() {
      public void execute() {
        onModuleLoad2();
      }
    });
  }

  public void onModuleLoad2() {
    Logger logger;

    logger = Logger.getLogger(Log4gwtDemo.class);
    logger = Logger.getLogger("some-logger");

    if (logger.isTraceEnabled()) {
      logger.trace("Trace");
      logger.trace("Trace", new Throwable());
    }

    if (logger.isDebugEnabled()) {
      logger.debug("debug");
      logger.debug("debug", new Throwable());
    }

    if (logger.isInfoEnabled()) {
      logger.info("Info");
      logger.info("Info", new Throwable());
    }

    logger.warn("Warn");
    logger.warn("Warn", new Throwable());

    logger.error("Error");
    logger.error("Error", new Throwable());

    logger.fatal("Fatal");
    logger.fatal("Fatal", new Throwable());

    logger.assertLog(2 + 2 == 5, "2 is insufficiently large");

    Log.clear();
    logger.info("That worked!");
    logger.getAdditivity();
  }
}
