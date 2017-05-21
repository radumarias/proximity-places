/**
 * 
 */
package com.candor.bp.client.google.place.model.json;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Native Geometry DTO marker class providing the means for consuming (in Java world) JSON resulted
 * after a XMLHttpRequest to {@link https://maps.googleapis.com/maps/api/place/...} API entry point.
 * 
 * @author bp
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class GeometryDTO {

	/* Properties */

	protected CoordinateDTO location;

	protected ViewpointDTO viewport;

	/* getters & setters */

	/**
	 * @return the location
	 */
	@JsProperty
	public native CoordinateDTO getLocation();
	/**
	 * @param location
	 *            the location to set
	 */
	@JsProperty
	public native void setLocation(CoordinateDTO location);

	/**
	 * @return the viewport
	 */
	@JsProperty
	public native ViewpointDTO getViewport();

	/**
	 * @param viewport
	 *            the viewport to set
	 */
	@JsProperty
	public native void setViewport(ViewpointDTO viewport);

}
