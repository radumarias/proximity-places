package com.candor.bp.client.google.place.model.json;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Native Autocomplete DTO marker class providing the means for consuming (in Java world) JSON
 * resulted after a XMLHttpRequest to
 * {@link https://maps.googleapis.com/maps/api/place/autocomplete} API entry point.
 *
 * @author bp
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public interface AutocompleteDTO {

	@JsProperty
	PredictionDTO[] getPredictions();
}
