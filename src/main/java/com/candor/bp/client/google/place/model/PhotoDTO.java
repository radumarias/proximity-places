package com.candor.bp.client.google.place.model;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Native Photo DTO marker class providing the means for consuming (in Java world) JSON resulted
 * after a XMLHttpRequest to {@link https://maps.googleapis.com/maps/api/place/photo} API entry
 * point.
 * 
 * @author bp
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class PhotoDTO {

	/* Properties */

	protected int height;

	protected String photo_reference;

	protected int width;

	/* getters & setters */

	/**
	 * @return the height
	 */
	@JsProperty
	public native int getHeight();

	/**
	 * @param height
	 *            the height to set
	 */
	@JsProperty
	public native void setHeight(int height);

	/**
	 * @return the photo_reference
	 */
	@JsProperty
	public native String getPhoto_reference();

	/**
	 * @param photo_reference
	 *            the photo_reference to set
	 */
	@JsProperty
	public native void setPhoto_reference(String photo_reference);

	/**
	 * @return the width
	 */
	@JsProperty
	public native int getWidth();

	/**
	 * @param width
	 *            the width to set
	 */
	@JsProperty
	public native void setWidth(int width);

}
