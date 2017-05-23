/**
 * 
 */
package com.candor.bp.client.event;

import java.util.List;

import com.candor.bp.client.google.place.model.json.CoordinateDTO;
import com.candor.bp.client.google.place.model.json.ResultDTO;
import com.google.gwt.event.shared.GwtEvent;

/**
 * @author bp
 *
 */
public class ViewPlacesMapEvent extends GwtEvent<ViewPlacesMapEventHandler> {

	public static final Type<ViewPlacesMapEventHandler> TYPE = new Type<ViewPlacesMapEventHandler>();

	private CoordinateDTO city;

	private List<ResultDTO> places;

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ViewPlacesMapEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ViewPlacesMapEventHandler handler) {
		handler.viewPlacesMap(this);
	}

	/**
	 * 
	 * @param city
	 * @param places
	 */
	public ViewPlacesMapEvent(CoordinateDTO city, List<ResultDTO> places) {
		this.city = city;
		this.places = places;
	}

	/**
	 * 
	 * @return {@link CoordinateDTO}
	 */
	public CoordinateDTO getCity() {
		return city;
	}

	/**
	 * 
	 * @return {@link List} of {@link ResultDTO}
	 */
	public List<ResultDTO> getPlaces() {
		return places;
	}

}
