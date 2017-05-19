/**
 * 
 */
package com.candor.bp.client.reqbuilder;

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
	 */
	default void onError() {
		ClientLoggingUtils.logToConsole(Level.SEVERE, "Error caught in scope of class " + getClass().getName());
	}
}