/**
 * 
 */
package com.candor.bp.client.google.map.model;

import com.candor.bp.client.google.place.model.json.CoordinateDTO;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * JavaScript-to-Java JsInterop wrapper class to provide convenience methods for working with
 * {@link google.maps.MapOptions} object in Java.
 * 
 * @author bp
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class MapOptions {

	/* Properties */

	protected CoordinateDTO center;

	protected int zoom;

	/* getters & setters */

	@JsProperty(name = "center")
	public native CoordinateDTO getCenter();

	@JsProperty(name = "center")
	public native void setCenter(CoordinateDTO center);

	@JsProperty(name = "zoom")
	public native int getZopm();

	@JsProperty(name = "zoom")
	public native void setZoom(int zoom);

	/* convenience methods */

	@JsOverlay
	public final MapOptions bundle(CoordinateDTO center, int zoom) {
		setCenter(center);
		setZoom(zoom);

		return this;
	}

}
