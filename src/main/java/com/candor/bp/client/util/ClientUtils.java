/**
 * 
 */
package com.candor.bp.client.util;

/**
 * Non-inheritable client utility class.
 * 
 * @author bp
 *
 */
public final class ClientUtils {

	/* Prevent instantiation. */
	private ClientUtils() {
		/*
		 * Just in case new instance is created inside the class and/or through GWT.create(), DI
		 */
		throw new AssertionError(getClass().getName() + " utility class cannot be instatiated.");
	}

}
