/**
 * 
 */
package com.candor.bp.client.google.place.callback;

import java.util.logging.Level;

import com.candor.bp.client.util.ClientLoggingUtils;

/**
 * HasErrorHandlers marker interface.
 * 
 * @author bp
 *
 */
public interface HasErrorHandlers {

	/**
	 * Provide error handling.
	 * <p>
	 * Contains default implementation.
	 * 
	 * @param t
	 * 
	 */
	default void onError(Throwable t) {
		ClientLoggingUtils.logToConsole(Level.SEVERE, t != null ? t.getMessage() : "Error caught in scope of class " + getClass().getName());
	}
}