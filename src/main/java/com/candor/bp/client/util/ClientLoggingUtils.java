/**
 * 
 */
package com.candor.bp.client.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility non-inheritable class providing the means for logging to the browser console.
 * 
 * @author bp
 *
 */
public final class ClientLoggingUtils {

	/* Prevent instantiation. */
	private ClientLoggingUtils() {
		/*
		 * Just in case new instance is created inside the class and/or through GWT.create(), DI
		 */
		throw new AssertionError(getClass().getName() + " utility class cannot be instatiated.");
	}

	/**
	 * GWT client-side browser console {@link Logger}.
	 */
	private static final Logger CONSOLE_LOGGER;
	static {
		CONSOLE_LOGGER = Logger.getLogger("ConsoleLogger");
	}

	/**
	 * Log message with {@link Level} identifier to browser console.
	 * 
	 * @param level
	 *            message level identifier
	 * @param message
	 *            string message to be logged
	 */
	public static void logToConsole(Level level, String message) {
		CONSOLE_LOGGER.log(level, message);
	}

	/**
	 * Log message to browser console.
	 * 
	 * @param message
	 *            string message to be logged
	 */
	public static void logToConsole(String message) {
		CONSOLE_LOGGER.log(Level.ALL, message);
	}

}
