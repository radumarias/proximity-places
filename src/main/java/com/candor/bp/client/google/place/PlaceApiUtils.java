/**
 * 
 */
package com.candor.bp.client.google.place;

import java.util.List;
import java.util.stream.Collectors;

import com.candor.bp.client.google.place.model.json.CoordinateDTO;
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
		API_KEY = "AIzaSyAJooCebBfpjwU4tMnAN_0ZY9xemMmdfA0";
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
		PHOTO_ENTRY_POINT = "photo";
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

	/* Parameters */

	public static final String KEYWORD_PARAM;
	static {
		KEYWORD_PARAM = "keyword=";
	}

	public static final String TYPE_PARAM;
	static {
		TYPE_PARAM = "type=";
	}

	public static final String TYPES_PARAM;
	static {
		TYPES_PARAM = "types=";
	}

	public static final String INPUT_PARAM;
	static {
		INPUT_PARAM = "input=";
	}

	public static final String KEY_PARAM;
	static {
		KEY_PARAM = "key=";
	}

	public static final String PLACE_ID_PARAM;
	static {
		PLACE_ID_PARAM = "placeid=";
	}

	public static final String PHOTO_REF_PARAM;
	static {
		PHOTO_REF_PARAM = "photoreference=";
	}

	public static final String MAX_WIDTH_PARAM;
	static {
		MAX_WIDTH_PARAM = "maxwidth=";
	}

	public static final String LOCATION_PARAM;
	static {
		LOCATION_PARAM = "location=";
	}

	public static final String RADIUS_PARAM;
	static {
		RADIUS_PARAM = "radius=";
	}

	public static final String PAGE_TOKEN_PARAM;
	static {
		PAGE_TOKEN_PARAM = "pagetoken=";
	}

	/* helper methods */

	/**
	 * Parse {@link CoordinateDTO} to Google Places API expected format.
	 * 
	 * @param location
	 * @return CSV of {@link CoordinateDTO} fields.
	 */
	public static String parseLocation(CoordinateDTO location) {
		return location.getLatitude() + "," + location.getLongitude();
	}

	/**
	 * 
	 * @param types
	 * @return String parameter in in Google Place API format
	 */
	public static String parseTypes(List<String> types) {
		if (types != null && !types.isEmpty()) {
			if (types.size() == 1) {
				return PlaceApiUtils.TYPE_PARAM + types.get(0);
			} else {
				return PlaceApiUtils.TYPE_PARAM + types.stream().collect(Collectors.joining("|"));
			}
		}

		return "";
	}

	/**
	 * 
	 * @param keyword
	 * @return String parameter in in Google Place API format
	 */
	public static String parseKeyword(String keyword) {
		if (keyword != null && !keyword.trim().isEmpty()) {
			return PlaceApiUtils.KEYWORD_PARAM + keyword;
		}

		return "";
	}

}
