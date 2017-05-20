/**
 * 
 */
package com.candor.bp.client.google.place;

/**
 * <code>enum</code> listing the supported values for the types property in the Google Places API.
 * 
 * @author bp
 *
 */
public enum PlaceType {

	//@formatter:off
	
	CITIES("(cities)"),
	
	AIRPORT("airport"),
	
	ART_GALLERY("art_gallery"),
	
	ATM("atm"),
	
	BAKERY("bakery"),
	
	BANK("bank"),
	
	BAR("bar"),
	
	CAFE("cafe"),
	
	CAR_RENTAL("car_rental"),
	
	CHURCH("church"),
	
	LIBRARY("library"),
	
	MUSEUM("museum"),
	
	NIGHT_CLUB("night_club"),
	
	PARK("park"),
	
	RESTAURANT("restaurant"),
	
	TAXI_STAND("taxi_stand"),
	
	TRAIN_STATION("train_station"),
	
	UNIVERSITY("university");
	
	//@formatter:on

	private final String typeName;

	PlaceType(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @return {@link #typeName}
	 */
	public String getTypeName() {
		return typeName;
	}

}
