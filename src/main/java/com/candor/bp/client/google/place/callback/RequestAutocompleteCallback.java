package com.candor.bp.client.google.place.callback;

import com.candor.bp.client.google.place.model.json.PredictionDTO;
import com.google.gwt.http.client.RequestCallback;

/**
 * {@link FunctionalInterface} providing the means of handling a
 * {@link https://maps.googleapis.com/maps/api/place/autocomplete} request callback in a decoupled
 * manner; i.e.
 * {@link RequestCallback#onResponseReceived(com.google.gwt.http.client.Request, com.google.gwt.http.client.Response)}
 * 
 * @author bp
 *
 */
@FunctionalInterface
public interface RequestAutocompleteCallback extends HasErrorHandlers {
	/**
	 * 
	 * @param array
	 *            Array of type {@link PredictionDTO}
	 */
	void onComplete(PredictionDTO[] predictions);
}
