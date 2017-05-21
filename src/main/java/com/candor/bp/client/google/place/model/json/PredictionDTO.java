package com.candor.bp.client.google.place.model.json;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Native Prediction DTO marker class providing the means for consuming JSON sources in Java world.
 * 
 * <p>
 * Setting <code>isNative = true</code> will tell GWT not to generate any code, as the contract it
 * is fulfilled by JavaScript objects available in native environment.
 * 
 * <p>
 * Setting <code>name = "Object"</code> will tell GWT that this has no clear prototype, it inherits
 * from the built-in object in the browser.
 * 
 * <p>
 * Setting <code>namespace = JsPackage.GLOBAL</code> will make {@link PredictionDTO} available in
 * the global JavaScript object namespace.
 * 
 * @author bp
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class PredictionDTO {

	/* Properties */

	/**
	 * Description.
	 * 
	 * Property <b>defined</b> in JavaScript world; i.e. attribute will neither be renamed, nor will
	 * it be pruned
	 */
	protected String description;

	/**
	 * ID.
	 * 
	 * Property <b>defined</b> in JavaScript world; i.e. attribute will neither be renamed, nor will
	 * it be pruned
	 */
	protected String id;

	/**
	 * Place ID.
	 * 
	 * Property <b>defined</b> in JavaScript world; i.e. attribute will neither be renamed, nor will
	 * it be pruned
	 */
	@JsProperty(name = "place_id")
	protected String placeId;

	/* getters & setters */

	/**
	 * @return the description
	 */
	@JsProperty
	public native String getDescription();

	/**
	 * @param description
	 *            the description to set
	 */
	@JsProperty
	public native void setDescription(String description);

	/**
	 * @return the id
	 */
	@JsProperty
	public native String getId();

	/**
	 * @param id
	 *            the id to set
	 */
	@JsProperty
	public native void setId(String id);

	/**
	 * @return the place_id
	 */
	@JsProperty(name = "place_id")
	public native String getPlaceId();

	/**
	 * @param place_id
	 *            the place_id to set
	 */
	@JsProperty(name = "place_id")
	public native void setPlaceId(String placeId);

}
