/**
 * 
 */
package com.candor.bp.client.google.place.model.json;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Native Nearby Places DTO marker class providing the means for consuming (in Java world) JSON
 * resulted after a XMLHttpRequest to
 * {@link https://maps.googleapis.com/maps/api/place/nearbysearch} API entry point.
 *
 * @author bp
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public interface NearbyPlacesDTO {

	@JsProperty(name = "next_page_token")
	String getNextPageToken();

	@JsProperty
	ResultDTO[] getResults();
}
