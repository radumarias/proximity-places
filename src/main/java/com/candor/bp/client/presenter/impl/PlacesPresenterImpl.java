package com.candor.bp.client.presenter.impl;

import com.candor.bp.client.presenter.PlacesPresenter;
import com.candor.bp.client.view.PlacesView;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

/**
 * @author bp
 *
 */

public class PlacesPresenterImpl implements PlacesPresenter {

	private PlacesView view;

	private final String cityId;

	@Inject
	public PlacesPresenterImpl(PlacesView view, @Assisted String cityId) {
		this.view = view;
		this.cityId = cityId;
		bind();
	}

	/**
	 * 
	 * @see com.candor.bp.client.presenter.Presenter#go(com.google.gwt.user.client.ui.HasOneWidget)
	 */
	@Override
	public void go(HasOneWidget container) {
		container.setWidget(view.asWidget());
	}

	/**
	 * 
	 * @see com.candor.bp.client.presenter.Presenter#bind()
	 */
	@Override
	public void bind() {
		view.setPresenter(this);
	}

	/**
	 * @return the city id
	 */
	@Override
	public String getCityId() {
		return cityId;
	}

	private void onViewPlacesMap() {
		// city := current city coord
		// places := collection of sll visible places
		/**
		 * Fire event to be handled upstream
		 */
		// AppGinjector.INSTANCE.getEventBus().fireEventFromSource(new ViewPlacesMapEvent(city,
		// places), PlacesView.class);
	}

}
