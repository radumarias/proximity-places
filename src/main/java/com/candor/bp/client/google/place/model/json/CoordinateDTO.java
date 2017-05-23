/**
 * 
 */
package com.candor.bp.client.google.place.model.json;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Native Coordinate DTO marker class providing the means for consuming (in Java world) JSON
 * resulted after a XMLHttpRequest to {@link https://maps.googleapis.com/maps/api/place/...} API
 * entry point.
 * 
 * @author bp
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class CoordinateDTO {

	/* Properties */

	/* Latitude */
	protected double lat;

	/* Longitude. */
	protected double lng;

	/* getters & setters */

	@JsProperty(name = "lat")
	public native double getLatitude();

	@JsProperty(name = "lat")
	public native void setLatitude(double lat);

	@JsProperty(name = "lng")
	public native double getLongitude();

	@JsProperty(name = "lng")
	public native void setLongitude(double lng);

	/* convenience methods */

	@JsOverlay
	public final CoordinateDTO bundle(double lat, double lng) {
		setLatitude(lat);
		setLongitude(lng);
		return this;
	}
}
