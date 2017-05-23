/**
 * 
 */
package com.candor.bp.client.google.map.model;

import com.candor.bp.client.google.map.Map;
import com.candor.bp.client.google.place.model.json.CoordinateDTO;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * JavaScript-to-Java JsInterop wrapper class to provide convenience methods for working with
 * {@link google.maps.MarkerOptions} object in Java.
 * 
 * @author bp
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class MarkerOptions {

	/* Properties */

	protected CoordinateDTO position;

	protected Map map;

	protected String title;

	protected String label;

	/* getters & setters */

	@JsProperty(name = "position")
	public native CoordinateDTO getPosition();

	@JsProperty(name = "position")
	public native void setPosition(CoordinateDTO position);

	@JsProperty(name = "title")
	public native String getTitle();

	@JsProperty(name = "title")
	public native void setTitle(String title);

	@JsProperty(name = "label")
	public native String getLabel();

	@JsProperty(name = "label")
	public native void setLabel(String label);

	@JsProperty(name = "map")
	public native Map getMap();

	@JsProperty(name = "map")
	public native void setMap(Map map);

	/* convenience methods */

	@JsOverlay
	public final MarkerOptions bundle(CoordinateDTO position, Map map, String title, String label) {
		setPosition(position);
		setMap(map);
		setTitle(title);
		setLabel(label);

		return this;
	}
}
