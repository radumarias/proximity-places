package com.candor.bp.client.google.place.model;

import com.candor.bp.client.google.place.model.json.GeometryDTO;
import com.candor.bp.client.google.place.model.json.OpeningHoursDTO;
import com.candor.bp.client.google.place.model.json.PhotoDTO;
import com.candor.bp.client.google.place.model.json.ResultDTO;

/**
 * Result MO, i.e. <em>Model Object</em> class.
 * 
 * @author bp
 *
 */
public class ResultMO extends ResultDTO {

	/* Properties */

	/**
	 * Transient property - will be neither persisted, nor wired.
	 */
	private transient String action;

	/* constructor */

	public ResultMO() {
		// nothing to do
	}

	/**
	 * @param description
	 * @param formatted_address
	 * @param formatted_phone_number
	 * @param geometry
	 * @param icon
	 * @param id
	 * @param international_phone_number
	 * @param name
	 * @param place_id
	 * @param rating
	 * @param types
	 * @param url
	 * @param vicinity
	 * @param website
	 * @param opening_hours
	 * @param photos
	 */
	public ResultMO(String description, String formatted_address, String formatted_phone_number, GeometryDTO geometry, String icon, String id,
			String international_phone_number, String name, String place_id, double rating, String[] types, String url, String vicinity, String website,
			OpeningHoursDTO opening_hours, PhotoDTO[] photos) {
		super();
		this.description = description;
		this.formatted_address = formatted_address;
		this.formatted_phone_number = formatted_phone_number;
		this.geometry = geometry;
		this.icon = icon;
		this.id = id;
		this.international_phone_number = international_phone_number;
		this.name = name;
		this.place_id = place_id;
		this.rating = rating;
		this.types = types;
		this.url = url;
		this.vicinity = vicinity;
		this.website = website;
		this.opening_hours = opening_hours;
		this.photos = photos;
	}

	public ResultMO(ResultDTO dto) {
		this(dto.getDescription(), dto.getFormatted_address(), dto.getFormatted_phone_number(), dto.getGeometry(), dto.getIcon(), dto.getId(),
				dto.getInternational_phone_number(), dto.getName(), dto.getPlace_id(), dto.getRating(), dto.getTypes(), dto.getUrl(), dto.getVicinity(),
				dto.getWebsite(), dto.getOpening_hours(), dto.getPhotos());
	}

	/* getters & setters */

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
