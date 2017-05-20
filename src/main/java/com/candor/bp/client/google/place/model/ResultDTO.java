package com.candor.bp.client.google.place.model;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Native Result DTO marker class providing the means for consuming (in Java world) JSON resulted
 * after a XMLHttpRequest to {@link https://maps.googleapis.com/maps/api/place/...} API entry point.
 * 
 * @author bp
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ResultDTO {

	/* Properties */

	protected String description;

	protected String formatted_address;

	protected String formatted_phone_number;

	protected GeometryDTO geometry;

	protected String icon;

	protected String international_phone_number;

	protected String name;

	protected String place_id;

	protected double rating;

	protected String[] types;

	protected String url;

	protected String vicinity;

	protected String website;

	protected OpeningHoursDTO opening_hours;

	protected PhotoDTO[] photos;

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
	 * @return the formatted_address
	 */
	@JsProperty
	public native String getFormatted_address();

	/**
	 * @param formatted_address
	 *            the formatted_address to set
	 */
	@JsProperty
	public native void setFormatted_address(String formatted_address);

	/**
	 * @return the formatted_phone_number
	 */
	@JsProperty
	public native String getFormatted_phone_number();

	/**
	 * @param formatted_phone_number
	 *            the formatted_phone_number to set
	 */
	@JsProperty
	public native void setFormatted_phone_number(String formatted_phone_number);

	/**
	 * @return the geometry
	 */
	@JsProperty
	public native GeometryDTO getGeometry();

	/**
	 * @param geometry
	 *            the geometry to set
	 */
	@JsProperty
	public native void setGeometry(GeometryDTO geometry);

	/**
	 * @return the icon
	 */
	@JsProperty
	public native String getIcon();

	/**
	 * @param icon
	 *            the icon to set
	 */
	@JsProperty
	public native void setIcon(String icon);

	/**
	 * @return the international_phone_number
	 */
	@JsProperty
	public native String getInternational_phone_number();

	/**
	 * @param international_phone_number
	 *            the international_phone_number to set
	 */
	@JsProperty
	public native void setInternational_phone_number(String international_phone_number);

	/**
	 * @return the name
	 */
	@JsProperty
	public native String getName();

	/**
	 * @param name
	 *            the name to set
	 */
	@JsProperty
	public native void setName(String name);

	/**
	 * @return the place_id
	 */
	@JsProperty
	public native String getPlace_id();

	/**
	 * @param place_id
	 *            the place_id to set
	 */
	@JsProperty
	public native void setPlace_id(String place_id);

	/**
	 * @return the rating
	 */
	@JsProperty
	public native double getRating();

	/**
	 * @param rating
	 *            the rating to set
	 */
	@JsProperty
	public native void setRating(double rating);

	/**
	 * @return the types
	 */
	@JsProperty
	public native String[] getTypes();

	/**
	 * @param types
	 *            the types to set
	 */
	@JsProperty
	public native void setTypes(String[] types);

	/**
	 * @return the url
	 */
	@JsProperty
	public native String getUrl();

	/**
	 * @param url
	 *            the url to set
	 */
	@JsProperty
	public native void setUrl(String url);

	/**
	 * @return the vicinity
	 */
	@JsProperty
	public native String getVicinity();

	/**
	 * @param vicinity
	 *            the vicinity to set
	 */
	@JsProperty
	public native void setVicinity(String vicinity);
	/**
	 * @return the website
	 */
	@JsProperty
	public native String getWebsite();

	/**
	 * @param website
	 *            the website to set
	 */
	@JsProperty
	public native void setWebsite(String website);

	/**
	 * @return the opening_hours
	 */
	@JsProperty
	public native OpeningHoursDTO getOpening_hours();

	/**
	 * @param opening_hours
	 *            the opening_hours to set
	 */
	@JsProperty
	public native void setOpening_hours(OpeningHoursDTO opening_hours);

	/**
	 * @return the photos
	 */
	@JsProperty
	public native PhotoDTO[] getPhotos();

	/**
	 * @param photos
	 *            the photos to set
	 */
	@JsProperty
	public native void setPhotos(PhotoDTO[] photos);

}
