package com.autoiq.common.utility;

import org.apache.log4j.Logger;

/**
 * This class consist the all log methods
 * 
 * @author bharatp : 04/04/2017
 *
 */
public class Log {
	final static Logger logger = Logger.getLogger(Log.class.getName());

	public static void info(String message) {
		logger.info(message);
	}

	public static void warn(String message) {
		logger.warn(message);
	}

	public static void error(String message) {
		logger.error(message);
	}

	public static void fatal(String message) {
		logger.fatal(message);
	}

	public static void debug(String message) {
		logger.debug(message);
	}
}
