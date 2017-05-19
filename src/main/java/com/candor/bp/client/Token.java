package com.candor.bp.client;

import com.google.gwt.user.client.History;

/**
 * Single Point of Entry Dictionary Class for {@link History} bookmark'able resources/places.
 * 
 * @author bp
 *
 */
public final class Token {

	/* Prevent instantiation. */
	private Token() {
		/*
		 * Just in case new instance is created inside the class and/or through GWT.create(), DI
		 */
		throw new AssertionError(getClass().getName() + " utility class cannot be instatiated.");
	}

	public static final String CITY = "city";
	public static final String PLACES = "places";
	public static final String PLACE_DETAILS = "place-details";

}
