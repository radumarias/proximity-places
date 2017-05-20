package com.candor.bp.client;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.candor.bp.client.google.place.PlaceApiUtils;
import com.candor.bp.client.google.place.PlaceType;
import com.candor.bp.client.google.place.callback.RequestAutocompleteCallback;
import com.candor.bp.client.google.place.callback.RequestDetailsCallback;
import com.candor.bp.client.google.place.callback.RequestNearbySearchCallback;
import com.candor.bp.client.google.place.callback.RequestPhotoCallback;
import com.candor.bp.client.google.place.model.AutocompleteDTO;
import com.candor.bp.client.google.place.model.CoordinateDTO;
import com.candor.bp.client.jsi.JSON;
import com.candor.bp.client.reqbuilder.ReqBuilder;
import com.google.gwt.http.client.Header;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.inject.Inject;

/**
 * Utility non-inheritable <b>Data/Request Manager</b> class providing data CRUD capabilities.
 * 
 * @author bp
 *
 */
public final class DataManager {

	/* Prevent explicit instantiation */
	@Inject
	private DataManager() {
		// nothing to do
	}

	/**
	 * Perform XMLHttpRequest.GET to fetch cities from Google Places.
	 * 
	 * @param callback
	 *            {@link RequestAutocompleteCallback}
	 * @param input
	 */
	public void getCityPredictions(final RequestAutocompleteCallback callback, final String input) {
		/* perform XMLHttpRequest.GET */
		//@formatter:off
		ReqBuilder.doRequest(
				RequestBuilder.GET,
				PlaceApiUtils.BASE_URL + PlaceApiUtils.AUTOCOMPLETE_ENTRY_POINT
									   + PlaceApiUtils.OUTPUT + "?"
									   + PlaceApiUtils.KEY_PARAM + PlaceApiUtils.API_KEY
									   + "&" + PlaceApiUtils.TYPES_PARAM + PlaceType.CITIES.getTypeName(),
				"&" + PlaceApiUtils.INPUT_PARAM + input,
				null,
				new RequestCallback() {
				//@formatter:on
					@Override
					public void onResponseReceived(Request request, Response response) {
						if (callback != null) {
							// SUCCESS
							if (200 == response.getStatusCode()) {
								callback.onComplete(((AutocompleteDTO) JSON.parse(response.getText())).getPredictions());
							}
							// otherwise
							else {
								callback.onError(null);
							}
						} else {
							throw new IllegalArgumentException("arg0 cannot be null");
						}
					}

					@Override
					public void onError(Request request, Throwable exception) {
						if (callback != null) {
							callback.onError(exception);
						} else {
							throw new IllegalArgumentException("arg0 cannot be null");
						}
					}
				});
	}

	/**
	 * Perform XMLHttpRequest.GET to fetch place details from Google Places.
	 * 
	 * @param callback
	 *            {@link RequestDetailsCallback}
	 * @param placeId
	 */
	public void getPlaceDetails(final RequestDetailsCallback callback, final String placeId) {
		/* perform XMLHttpRequest.GET */
		//@formatter:off
		ReqBuilder.doRequest(
				RequestBuilder.GET,
				PlaceApiUtils.BASE_URL + PlaceApiUtils.DETAILS_ENTRY_POINT
									   + PlaceApiUtils.OUTPUT + "?"
									   + PlaceApiUtils.KEY_PARAM + PlaceApiUtils.API_KEY,
				"&" + PlaceApiUtils.PLACE_ID_PARAM + placeId,
				null,
				new RequestCallback() {
				//@formatter:on
					@Override
					public void onResponseReceived(Request request, Response response) {
						if (callback != null) {
							// SUCCESS
							if (200 == response.getStatusCode()) {
								callback.onComplete(JSON.parse(response.getText()));
							}
							// otherwise
							else {
								callback.onError(null);
							}
						} else {
							throw new IllegalArgumentException("arg0 cannot be null");
						}
					}

					@Override
					public void onError(Request request, Throwable exception) {
						if (callback != null) {
							callback.onError(exception);
						} else {
							throw new IllegalArgumentException("arg0 cannot be null");
						}
					}
				});
	}

	/**
	 * Perform XMLHttpRequest.HEAD to fetch photo from Google Places.
	 * 
	 * @param callback
	 *            {@link RequestPhotoCallback}
	 * @param photoReference
	 * @param maxWidth
	 */
	public void getPlacePhoto(final RequestPhotoCallback callback, final String photoReference, final int maxWidth) {
		/* perform XMLHttpRequest.HEAD */
		//@formatter:off
		ReqBuilder.doRequest(
				RequestBuilder.HEAD,
				PlaceApiUtils.BASE_URL + PlaceApiUtils.PHOTO_ENTRY_POINT
									   + "?" 
									   + PlaceApiUtils.KEY_PARAM + PlaceApiUtils.API_KEY,
				"&" + PlaceApiUtils.PHOTO_REF_PARAM + photoReference
				+ "&" + PlaceApiUtils.MAX_WIDTH_PARAM + maxWidth,
				null,
				new RequestCallback() {
				//@formatter:on
					@Override
					public void onResponseReceived(Request request, Response response) {
						if (callback != null) {
							/*
							 * SUCCESS
							 * 
							 * TODO - handle auto-redirects, as the current approach may not play
							 * nice with SOP
							 */
							if (302 == response.getStatusCode()) {
								// @formatter:off
								final Optional<Header> location = Arrays.stream(response.getHeaders())
																				.filter(header -> "location".equalsIgnoreCase(header.getName()))
																					.findFirst();
								// @formatter:on
								if (location.isPresent()) {
									callback.onComplete(location.get().getValue());
								} else {
									callback.onError(new NoSuchElementException("Location HTTP Header item is missing."));
								}
							}
							// otherwise
							else {
								callback.onError(null);
							}
						} else {
							throw new IllegalArgumentException("arg0 cannot be null");
						}
					}

					@Override
					public void onError(Request request, Throwable exception) {
						if (callback != null) {
							callback.onError(exception);
						} else {
							throw new IllegalArgumentException("arg0 cannot be null");
						}
					}
				});
	}

	/**
	 * Perform XMLHttpRequest.GET to fetch nearby places from Google Places.
	 * 
	 * @param callback
	 *            {@link RequestNearbySearchCallback}
	 * 
	 * @param location
	 * @param radius
	 * @param keyword
	 * @param types
	 */
	public void getNearbyPlaces(final RequestNearbySearchCallback callback, final CoordinateDTO location, final int radius, final String keyword,
			final List<String> types) {
		/* perform XMLHttpRequest.GET */
		//@formatter:off
		ReqBuilder.doRequest(
				RequestBuilder.GET,
				PlaceApiUtils.BASE_URL + PlaceApiUtils.NEARBY_ENTRY_POINT
				   					   + PlaceApiUtils.OUTPUT + "?"
				   					   + PlaceApiUtils.KEY_PARAM + PlaceApiUtils.API_KEY,
				"&" + PlaceApiUtils.LOCATION_PARAM + PlaceApiUtils.parseLocation(location)
				+ "&" +  PlaceApiUtils.RADIUS_PARAM + radius
			    + "&" + PlaceApiUtils.parseTypes(types)
			    + "&" + PlaceApiUtils.parseKeyword(keyword),
				null,
				new RequestCallback() {
				//@formatter:on
					@Override
					public void onResponseReceived(Request request, Response response) {
						if (callback != null) {
							// SUCCESS
							if (200 == response.getStatusCode()) {
								callback.onComplete(JSON.parse(response.getText()));
							}
							// otherwise
							else {
								callback.onError(null);
							}
						} else {
							throw new IllegalArgumentException("arg0 cannot be null");
						}
					}

					@Override
					public void onError(Request request, Throwable exception) {
						if (callback != null) {
							callback.onError(exception);
						} else {
							throw new IllegalArgumentException("arg0 cannot be null");
						}
					}
				});
	}

}
