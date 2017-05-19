/**
 * 
 */
package com.candor.bp.client.util.google;

import com.candor.bp.client.reqbuilder.ReqBuilder;

/**
 * Repository/utility non-inheritable class providing access to
 * {@link https://developers.google.com/places/web-service} API.
 * 
 * @author bp
 *
 */
public final class PlaceApiUtils {

	/* Prevent instantiation. */
	private PlaceApiUtils() {
		/*
		 * Just in case new instance is created inside the class and/or through GWT.create(), DI
		 */
		throw new AssertionError(getClass().getName() + " utility class cannot be instatiated.");
	}

	/**
	 * Navigate to {@link https://developers.google.com/places/web-service/get-api-key} to generate
	 * a new key.
	 */
	public static final String API_KEY;
	static {
		API_KEY = "AIzaSyAZ69XqWS2EL-dJsiZ2XHl0Xtnub8_Il6I";
	}

	public static final String BASE_URL;
	static {
		BASE_URL = "https://maps.googleapis.com/maps/api/place/";
	}

	public static final String NEARBY_ENTRY_POINT;
	static {
		NEARBY_ENTRY_POINT = "nearbysearch/";
	}

	public static final String DETAILS_ENTRY_POINT;
	static {
		DETAILS_ENTRY_POINT = "details/";
	}

	public static final String PHOTO_ENTRY_POINT;
	static {
		PHOTO_ENTRY_POINT = "photo/";
	}

	public static final String AUTOCOMPLETE_ENTRY_POINT;
	static {
		AUTOCOMPLETE_ENTRY_POINT = "autocomplete/";
	}

	/**
	 * JSON is the response representation set in
	 * {@link ReqBuilder#doRequest(com.google.gwt.http.client.RequestBuilder.Method, String, String, String, com.google.gwt.http.client.RequestCallback)}
	 * headers.
	 * 
	 * Google recommended output is JavaScript Object Notation (JSON)
	 */
	public static final String OUTPUT;
	static {
		OUTPUT = "json";
	}

}
