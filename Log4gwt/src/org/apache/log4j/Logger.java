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

import com.google.gwt.core.client.GWT;

import com.allen_sauer.gwt.log.client.Log;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

//CHECKSTYLE_JAVADOC_OFF
public final class Logger {
  private static final Enumeration<Appender> EMPTY_ENUMERATION = new Enumeration<Appender>() {
    public boolean hasMoreElements() {
      return false;
    }

    public Appender nextElement() {
      throw new NoSuchElementException();
    }
  };
  private static HashMap<String, Logger> loggerMap = new HashMap<String, Logger>();
  private static final Logger rootLogger = new Logger("RootLogger");
  private static boolean warnedUnimplemented;

  @Deprecated
  public static Logger getInstance(Class<?> clazz) {
    return getLogger(clazz);
  }

  @Deprecated
  public static Logger getInstance(String name) {
    return getLogger(name);
  }

  public static Logger getLogger(Class<?> clazz) {
    return getLogger(clazz.getName());
  }

  public static Logger getLogger(String name) {
    Logger logger = loggerMap.get(name);
    if (logger == null) {
      logger = new Logger(name);
    }
    return logger;
  }

  @Deprecated
  public static Logger getRoot() {
    return getRootLogger();
  }

  public static Logger getRootLogger() {
    return rootLogger;
  }

  static void unimplemented() {
    if (!warnedUnimplemented && !GWT.isScript()) {
      Log.warn("Your application uses portions of the 'Apache Log4j' API which have not (yet) been implemented by 'log4gwt'");
      warnedUnimplemented = true;
    }
  }

  protected boolean additive = true;

  protected volatile Level level;

  protected String name;

  protected Logger parent;

  protected ResourceBundle resourceBundle;

  private Logger(String name) {
    assert !loggerMap.containsKey(name);
    this.name = name;
    if (this != rootLogger) {
      parent = rootLogger;
    }
    loggerMap.put(name, this);
  }

  public synchronized void addAppender(Appender newAppender) {
    unimplemented();
  }

  public void assertLog(boolean assertion, String message) {
    if (!assertion) {
      Log.error(formatMessage(message));
    }
  }

  public void debug(Object message) {
    Log.debug(formatMessage(message));
  }

  public void debug(Object message, Throwable t) {
    Log.debug(formatMessage(message), t);
  }

  public void error(Object message) {
    Log.error(formatMessage(message));
  }

  public void error(Object message, Throwable t) {
    Log.error(formatMessage(message), t);
  }

  public void fatal(Object message) {
    Log.fatal(formatMessage(message));
  }

  public void fatal(Object message, Throwable t) {
    Log.fatal(formatMessage(message), t);
  }

  public boolean getAdditivity() {
    return additive;
  }

  public synchronized Enumeration<Appender> getAllAppenders() {
    unimplemented();
    return EMPTY_ENUMERATION;
  }

  public synchronized Appender getAppender(String name) {
    unimplemented();
    return null;
  }

  @Deprecated
  public Level getChainedPriority() {
    return getEffectiveLevel();
  }

  public Level getEffectiveLevel() {
    Logger logger = this;
    do {
      Level lvl = logger.getLevel();
      if (lvl != null) {
        return lvl;
      }
      logger = logger.getParent();
    } while (logger != null);
    assert false : "broken logger hierarchy";
    return null;
  }

  public Level getLevel() {
    return level;
  }

  public String getName() {
    return name;
  }

  public Logger getParent() {
    return parent;
  }

  @Deprecated
  public Level getPriority() {
    return getLevel();
  }

  public ResourceBundle getResourceBundle() {
    unimplemented();
    return null;
  }

  public void info(Object message) {
    Log.info(formatMessage(message));
  }

  public void info(Object message, Throwable t) {
    Log.info(formatMessage(message), t);
  }

  public boolean isAttached(Appender appender) {
    unimplemented();
    return false;
  }

  public boolean isDebugEnabled() {
    return Log.isDebugEnabled();
  }

  public boolean isEnabledFor(Level level) {
    unimplemented();
    return true;
  }

  public boolean isInfoEnabled() {
    return Log.isInfoEnabled();
  }

  public boolean isTraceEnabled() {
    return Log.isTraceEnabled();
  }

  public void l7dlog(Level level, String key, Object[] params, Throwable t) {
    unimplemented();
  }

  public void l7dlog(Level level, String key, Throwable t) {
    unimplemented();
  }

  public void log(Level level, Object message) {
    unimplemented();
  }

  public void log(Level level, Object message, Throwable t) {
    unimplemented();
  }

  public void log(String callerFQCN, Level level, Object message, Throwable t) {
    unimplemented();
  }

  public synchronized void removeAllAppenders() {
    unimplemented();
  }

  public synchronized void removeAppender(Appender appender) {
    unimplemented();
  }

  public synchronized void removeAppender(String name) {
    unimplemented();
  }

  public void setAdditivity(boolean additive) {
    unimplemented();
  }

  public void setLevel(Level level) {
    unimplemented();
  }

  @Deprecated
  public void setPriority(Level level) {
    setLevel(level);
  }

  public void setResourceBundle(ResourceBundle bundle) {
    unimplemented();
  }

  public void trace(Object message) {
    Log.trace(formatMessage(message));
  }

  public void trace(Object message, Throwable t) {
    Log.trace(formatMessage(message), t);
  }

  public void warn(Object message) {
    Log.warn(formatMessage(message));
  }

  public void warn(Object message, Throwable t) {
    Log.warn(formatMessage(message), t);
  }

  protected void forcedLog(String fqcn, Level level, Object message, Throwable t) {
    unimplemented();
  }

  protected String getResourceBundleString(String key) {
    unimplemented();
    return null;
  }

  synchronized void closeNestedAppenders() {
  }

  private String formatMessage(Object message) {
    return "[" + name + "]" + (message == null ? null : message.toString());
  }
}
