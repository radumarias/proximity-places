/**
 * 
 */
package com.candor.bp.client.google.place.callback;

import com.google.gwt.http.client.RequestCallback;

/**
 * {@link FunctionalInterface} providing the means of handling a
 * {@link https://maps.googleapis.com/maps/api/place/photo} request callback in a decoupled manner;
 * i.e.
 * {@link RequestCallback#onResponseReceived(com.google.gwt.http.client.Request, com.google.gwt.http.client.Response)}
 * 
 * @author bp
 *
 */
@FunctionalInterface
public interface RequestPhotoCallback extends HasErrorHandlers {
	/**
	 * 
	 * @param photo
	 *            String
	 */
	void onComplete(String photoUrl);
}
