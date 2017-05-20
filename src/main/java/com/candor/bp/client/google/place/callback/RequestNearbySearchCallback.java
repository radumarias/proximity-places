/**
 * 
 */
package com.candor.bp.client.google.place.callback;

import com.candor.bp.client.google.place.model.NearbyPlacesDTO;
import com.google.gwt.http.client.RequestCallback;

/**
 * {@link FunctionalInterface} providing the means of handling a
 * {@link https://maps.googleapis.com/maps/api/place/nearbysearch} request callback in a decoupled
 * manner. i.e.
 * {@link RequestCallback#onResponseReceived(com.google.gwt.http.client.Request, com.google.gwt.http.client.Response)}
 * 
 * @author bp
 *
 */
@FunctionalInterface
public interface RequestNearbySearchCallback extends HasErrorHandlers {
	/**
	 * 
	 * @param nearbyPlaces
	 *            {@link NearbyPlacesDTO}
	 */
	void onComplete(NearbyPlacesDTO nearbyPlaces);
}
