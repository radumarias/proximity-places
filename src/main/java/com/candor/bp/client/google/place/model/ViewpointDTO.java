/**
 * 
 */
package com.candor.bp.client.google.place.model;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Native Viewpoint DTO marker class providing the means for consuming (in Java world) JSON resulted
 * after a XMLHttpRequest to {@link https://maps.googleapis.com/maps/api/place/...} API entry point.
 * 
 * @author bp
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ViewpointDTO {

	/* Properties */

	protected CoordinateDTO northeast;

	protected CoordinateDTO southwest;

	/* getters & setters */

	/**
	 * @return the northeast
	 */
	@JsProperty
	public native CoordinateDTO getNortheast();

	/**
	 * @param northeast
	 *            the northeast to set
	 */
	@JsProperty
	public native void setNortheast(CoordinateDTO northeast);

	/**
	 * @return the southwest
	 */
	@JsProperty
	public native CoordinateDTO getSouthwest();

	/**
	 * @param southwest
	 *            the southwest to set
	 */
	@JsProperty
	public native void setSouthwest(CoordinateDTO southwest);

}
