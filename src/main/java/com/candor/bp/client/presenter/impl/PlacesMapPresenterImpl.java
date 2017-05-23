/**
 * 
 */
package com.candor.bp.client.presenter.impl;

import com.candor.bp.client.presenter.PlacesMapPresenter;
import com.candor.bp.client.view.PlacesMapView;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.inject.Inject;

/**
 * @author bp
 *
 */
public class PlacesMapPresenterImpl implements PlacesMapPresenter {

	private PlacesMapView view;

	/**
	 * @param view
	 */
	@Inject
	public PlacesMapPresenterImpl(PlacesMapView view) {
		this.view = view;
		bind();
	}

	/**
	 * 
	 * @see com.candor.bp.client.presenter.Presenter#go(com.google.gwt.user.client.ui.HasOneWidget)
	 */
	@Override
	public void go(HasOneWidget container) {
		container.setWidget(view.asWidget());

		// TODO - remove temporary code
		// CoordinateDTO position = new CoordinateDTO().bundle(48, 11);
		// Map map = new Map(Document.get().getElementById("map"), new MapOptions().bundle(position,
		// 11));
		// new Marker(new MarkerOptions().bundle(position, map, "A", "B"));
		// new Marker(new MarkerOptions().bundle(new CoordinateDTO().bundle(48, 11.01), map, "C",
		// "D"));
		// new Marker(new MarkerOptions().bundle(new CoordinateDTO().bundle(48, 11.02), map, "E",
		// "F"));
	}

	/**
	 * 
	 * @see com.candor.bp.client.presenter.Presenter#bind()
	 */
	@Override
	public void bind() {
		view.setPresenter(this);
	}

}
