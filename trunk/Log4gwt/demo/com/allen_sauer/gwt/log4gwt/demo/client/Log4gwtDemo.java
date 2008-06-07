/*
 * Copyright 2008 Fred Sauer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
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

  /**
   * Deferred entry point.
   */
  public void onModuleLoad2() {
    Logger logger;

    logger = Logger.getLogger(Log4gwtDemo.class);
    logger = Logger.getLogger("some-logger");

    if (logger.isTraceEnabled()) {
      logger.trace("Trace");
      logger.trace("Trace", new Throwable());
    }

    if (logger.isTraceEnabled()) {
      logger.trace("trace");
      logger.trace("trace", new Throwable());
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
