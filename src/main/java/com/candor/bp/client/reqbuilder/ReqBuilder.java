/**
 * 
 */
package com.candor.bp.client.reqbuilder;

import java.util.logging.Level;

import com.candor.bp.client.util.ClientLoggingUtils;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestBuilder.Method;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;

/**
 * Utility non-inheritable class providing the means of using GWT {@link RequestBuilder}
 * communication mechanism/protocol/abstraction.
 * 
 * @author bp
 *
 */
public final class ReqBuilder {

	/* Prevent instantiation. */
	private ReqBuilder() {
		/*
		 * Just in case new instance is created inside the class and/or through GWT.create(), DI
		 */
		throw new AssertionError(getClass().getName() + " utility class cannot be instatiated.");
	}

	/**
	 * Build and send HTTP request with {@link RequestBuilder#sendRequest(String, RequestCallback)}.
	 * 
	 * @param method
	 *            {@link Method}
	 * @param baseUrl
	 *            base URL; cannot be null
	 * @param urlSuffix
	 *            URL suffix; null values are ignored
	 * @param data
	 *            data stream
	 * @param requestCallback
	 *            {@link RequestCallback} object
	 */
	public static void doRequest(Method method, String baseUrl, String urlSuffix, String data, RequestCallback requestCallback) {
		final RequestBuilder requestBuilder = new RequestBuilder(method, urlSuffix != null ? baseUrl + urlSuffix : baseUrl);
		requestBuilder.setHeader("X-Requested-With", "XMLHttpRequest");
		requestBuilder.setHeader("If-Modified-Since", "01 Jan 1970 00:00:00 GMT");
		requestBuilder.setHeader("Access-Control-Allow-Origin", "*");
		requestBuilder.setHeader("Content-Type", "application/json; charset=utf-8");
		requestBuilder.setHeader("Accept", "application/json; charset=utf-8");

		try {
			requestBuilder.sendRequest(data, requestCallback);
		} catch (RequestException e) {
			ClientLoggingUtils.logToConsole(Level.SEVERE, e.getMessage());
		}
	}

}
