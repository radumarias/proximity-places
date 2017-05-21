package com.candor.bp.client.google.place.model;

import com.candor.bp.client.google.place.model.json.PredictionDTO;

/**
 * Prediction MO, i.e.e <em>Model Object</em> class.
 * 
 * @author bp
 *
 */
public class PredictionMO extends PredictionDTO {

	/* Properties */

	/**
	 * Transient property - will be neither persisted, nor wired.
	 */
	private transient String action;

	/* constructor */

	public PredictionMO() {
		// nothing to do
	}

	public PredictionMO(String id, String placeId, String description) {
		this.id = id;
		this.placeId = placeId;
		this.description = description;
	}

	public PredictionMO(PredictionDTO dto) {
		this(dto.getId(), dto.getPlaceId(), dto.getPlaceId());
	}

	/* getters & setters */

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
