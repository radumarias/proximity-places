/**
 * 
 */
package com.candor.bp.client.google.map;

import com.candor.bp.client.google.map.model.MapOptions;
import com.google.gwt.dom.client.Element;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsType;

/**
 * JavaScript-to-Java JsInterop wrapper class to provide convenience methods for working with
 * {@link google.maps.Map} object in Java.
 * 
 * @author bp
 *
 */
@JsType(isNative = true, namespace = "google.maps")
public class Map {

	/**
	 * Constructor method.
	 * 
	 * @param element
	 * @param opts
	 */
	@JsConstructor
	public Map(Element element, MapOptions opts) {
		// nothing to do
	}
}
