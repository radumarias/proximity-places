package com.candor.bp.client.google.place.model.json;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Native Details DTO marker class providing the means for consuming (in Java world) JSON resulted
 * after a XMLHttpRequest to {@link https://maps.googleapis.com/maps/api/place/details} API entry
 * point.
 * 
 * @author bp
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public interface DetailsDTO {

	@JsProperty
	ResultDTO getResult();

}
