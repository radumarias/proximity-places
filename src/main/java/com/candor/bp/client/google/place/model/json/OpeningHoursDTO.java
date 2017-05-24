/**
 * 
 */
package com.candor.bp.client.google.place.model.json;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Native Opening Hours DTO marker class providing the means for consuming (in Java world) JSON
 * resulted after a XMLHttpRequest to {@link https://maps.googleapis.com/maps/api/place/...} API
 * entry point.
 * 
 * @author bp
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class OpeningHoursDTO {

	/* Properties */

	protected boolean open_now;

	protected String[] weekday_text;

	/* getters & setters */

	/**
	 * @return the open_now
	 */
	@JsProperty
	public native boolean isOpen_now();

	/**
	 * @param open_now
	 *            the open_now to set
	 */
	@JsProperty
	public native void setOpen_now(boolean open_now);

	/**
	 * @return the weekday_text
	 */
	@JsProperty
	public native String[] getWeekday_text();

	/**
	 * @param weekday_text
	 *            the weekday_text to set
	 */
	@JsProperty
	public native void setWeekday_text(String[] weekday_text);

}
