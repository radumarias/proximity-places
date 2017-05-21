/**
 * 
 */
package com.candor.bp.client.google.place.callback;

import com.candor.bp.client.google.place.model.json.DetailsDTO;
import com.google.gwt.http.client.RequestCallback;

/**
 * {@link FunctionalInterface} providing the means of handling a
 * {@link https://maps.googleapis.com/maps/api/place/details} request callback in a decoupled
 * manner; i.e.
 * {@link RequestCallback#onResponseReceived(com.google.gwt.http.client.Request, com.google.gwt.http.client.Response)}
 * .
 * 
 * @author bp
 *
 */
@FunctionalInterface
public interface RequestDetailsCallback extends HasErrorHandlers {
	/**
	 * 
	 * @param details
	 *            {@link DetailsDTO}
	 */
	void onComplete(DetailsDTO details);
}
