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
package org.apache.log4j;

import com.allen_sauer.gwt.log.client.Log;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class Logger {

  private static final Logger rootLogger = new Logger();

  private Logger() {
  }

  public boolean isTraceEnabled() {
    return Log.isDebugEnabled();
  }

  public void trace(Object message, Throwable t) {
    Log.debug(nullOrToString(message), t);
  }

  public void trace(Object message) {
    Log.debug(nullOrToString(message));
  }

  public synchronized void addAppender(Appender newAppender) {
    throw new UnsupportedOperationException();
  }

  public void assertLog(boolean assertion, String msg) {
    if (!assertion) {
      Log.error(msg);
    }
  }

  public void callAppenders(LoggingEvent event) {
    throw new UnsupportedOperationException();
  }

  public void debug(Object message, Throwable t) {
    Log.debug(nullOrToString(message), t);
  }

  private String nullOrToString(Object message) {
    return message == null ? null : message.toString();
  }

  public void debug(Object message) {
    Log.debug(nullOrToString(message));
  }

  public void error(Object message, Throwable t) {
    Log.error(nullOrToString(message), t);
  }

  public void error(Object message) {
    Log.error(nullOrToString(message));
  }

  public void fatal(Object message, Throwable t) {
    Log.fatal(nullOrToString(message), t);
  }

  public void fatal(Object message) {
    Log.fatal(nullOrToString(message));
  }

  protected void forcedLog(String fqcn, Priority level, Object message, Throwable t) {
    throw new UnsupportedOperationException();
  }

  public boolean getAdditivity() {
    throw new UnsupportedOperationException();
  }

  public synchronized Enumeration getAllAppenders() {
    throw new UnsupportedOperationException();
  }

  public synchronized Appender getAppender(String name) {
    throw new UnsupportedOperationException();
  }

  public Priority getChainedPriority() {
    throw new UnsupportedOperationException();
  }

  public Level getEffectiveLevel() {
    throw new UnsupportedOperationException();
  }

  public LoggerRepository getHierarchy() {
    throw new UnsupportedOperationException();
  }

  public LoggerRepository getLoggerRepository() {
    throw new UnsupportedOperationException();
  }

  public ResourceBundle getResourceBundle() {
    throw new UnsupportedOperationException();
  }

  protected String getResourceBundleString(String key) {
    throw new UnsupportedOperationException();
  }

  public void info(Object message, Throwable t) {
    Log.info(nullOrToString(message), t);
  }

  public void info(Object message) {
    Log.info(nullOrToString(message));
  }

  public boolean isAttached(Appender appender) {
    throw new UnsupportedOperationException();
  }

  public boolean isDebugEnabled() {
    return Log.isDebugEnabled();
  }

  public boolean isEnabledFor(Priority level) {
    throw new UnsupportedOperationException();
  }

  public boolean isInfoEnabled() {
    return Log.isInfoEnabled();
  }

  public void l7dlog(Priority priority, String key, Object[] params, Throwable t) {
    throw new UnsupportedOperationException();
  }

  public void l7dlog(Priority priority, String key, Throwable t) {
    throw new UnsupportedOperationException();
  }

  public void log(Priority priority, Object message, Throwable t) {
    throw new UnsupportedOperationException();
  }

  public void log(Priority priority, Object message) {
    throw new UnsupportedOperationException();
  }

  public void log(String callerFQCN, Priority level, Object message, Throwable t) {
    throw new UnsupportedOperationException();
  }

  public synchronized void removeAllAppenders() {
    throw new UnsupportedOperationException();
  }

  public synchronized void removeAppender(Appender appender) {
    throw new UnsupportedOperationException();
  }

  public synchronized void removeAppender(String name) {
    throw new UnsupportedOperationException();
  }

  public void setAdditivity(boolean additive) {
    throw new UnsupportedOperationException();
  }

  public void setLevel(Level level) {
    throw new UnsupportedOperationException();
  }

  public void setPriority(Priority priority) {
    throw new UnsupportedOperationException();
  }

  public void setResourceBundle(ResourceBundle bundle) {
    throw new UnsupportedOperationException();
  }

  public void warn(Object message, Throwable t) {
    Log.warn(nullOrToString(message), t);
  }

  public void warn(Object message) {
    Log.warn(nullOrToString(message));
  }

  static public Logger getLogger(String name) {
    // TODO return different loggers
    return rootLogger;
  }

  static public Logger getLogger(Class clazz) {
    // TODO return different loggers
    return rootLogger;
  }

  public static Logger getRootLogger() {
    throw new UnsupportedOperationException();
  }

  public static Logger getLogger(String name, LoggerFactory factory) {
    throw new UnsupportedOperationException();
  }
}
