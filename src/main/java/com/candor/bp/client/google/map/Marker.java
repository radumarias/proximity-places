/**
 * 
 */
package com.candor.bp.client.google.map;

import com.candor.bp.client.google.map.model.MarkerOptions;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * JavaScript-to-Java JsInterop wrapper class to provide convenience methods for working with
 * {@link google.maps.Marker} object in Java.
 * 
 * @author bp
 *
 */
@JsType(isNative = true, namespace = "google.maps")
public class Marker {

	/**
	 * Constructor method.
	 * 
	 * @param opts
	 */
	@JsConstructor
	public Marker(MarkerOptions opts) {
		// nothing to do
	}

}
