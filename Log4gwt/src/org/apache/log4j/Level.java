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

//CHECKSTYLE_JAVADOC_OFF
@SuppressWarnings("serial")
public class Level {

  public static final Level ALL;

  public static final int ALL_INT = Integer.MIN_VALUE;
  public static final Level DEBUG;
  public static final int DEBUG_INT = Log.LOG_LEVEL_DEBUG;
  public static final Level ERROR;
  public static final int ERROR_INT = Log.LOG_LEVEL_ERROR;
  public static final Level FATAL;
  public static final int FATAL_INT = Log.LOG_LEVEL_FATAL;
  public static final Level INFO;
  //  public static final int ALL_INT = Log.LOG_LEVEL_ALL;
  public static final int INFO_INT = Log.LOG_LEVEL_INFO;
  public static final Level OFF;
  public static final int OFF_INT = Log.LOG_LEVEL_OFF;
  public static final Level TRACE;
  public static final int TRACE_INT = Log.LOG_LEVEL_TRACE;
  public static final Level WARN;
  public static final int WARN_INT = Log.LOG_LEVEL_WARN;

  static {
    ALL = new Level(ALL_INT, "ALL");
    DEBUG = new Level(DEBUG_INT, "DEBUG");
    ERROR = new Level(ERROR_INT, "ERROR");
    FATAL = new Level(FATAL_INT, "FATAL");
    INFO = new Level(INFO_INT, "INFO");
    OFF = new Level(OFF_INT, "OFF");
    TRACE = new Level(TRACE_INT, "TRACE");
    WARN = new Level(WARN_INT, "WARN");
  }
  private final int level;

  private final String levelStr;

  private Level(int level, String levelStr) {
    this.level = level;
    this.levelStr = levelStr;
  }

  public final int getSyslogEquivalent() {
    Logger.unimplemented();
    return 7;
  }

  public boolean isGreaterOrEqual(Level r) {
    return level >= r.level;
  }

  public int toInt() {
    return level;
  }

  @Override
  public String toString() {
    return levelStr;
  }

}
