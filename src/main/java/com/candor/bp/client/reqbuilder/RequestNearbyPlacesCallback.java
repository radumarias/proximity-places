/**
 * 
 */
package com.candor.bp.client.reqbuilder;

import com.google.gwt.http.client.RequestCallback;

/**
 * {@link FunctionalInterface} providing the means of handling
 * {@link RequestCallback#onResponseReceived(com.google.gwt.http.client.Request, com.google.gwt.http.client.Response)}
 * in a decoupled manner.
 * 
 * @author bp
 *
 */
@FunctionalInterface
public interface RequestNearbyPlacesCallback extends HasErrorHandlers {
	/**
	 * 
	 * @param statusCode
	 *            HTTP status code
	 */
	void onComplete(int statusCode);
}
