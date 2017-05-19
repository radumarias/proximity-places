package com.candor.bp.client.jsi;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * JavaScript-to-Java JsInterop wrapper class to provide convenience methods for using native
 * <b>JSON</b> functions in Java.
 * 
 * <p>
 * Setting isNative to true will tell GWT not to generate any code, as all implementation is
 * available within the jQuery JavaScript library
 * </p>
 * 
 * @author bp
 * 
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class JSON {

	// prevent manual instantiation
	private JSON() {
		// nothing to do
	}

	/**
	 * Converts a value to JSON.
	 * 
	 * @param <T>
	 * @param obj
	 *            <T> instance
	 * @return JSON expression
	 */
	public native static <T> String stringify(T obj);

	/**
	 * Evaluates a JSON expression.
	 * 
	 * @param <T>
	 * @param json
	 * @return <T> instance
	 */
	public native static <T> T parse(String json);

}