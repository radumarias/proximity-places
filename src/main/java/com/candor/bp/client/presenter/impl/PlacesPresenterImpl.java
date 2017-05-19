/**
 * 
 */
package com.candor.bp.client.presenter.impl;

import com.candor.bp.client.presenter.PlacesPresenter;
import com.candor.bp.client.view.PlacesView;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.inject.Inject;

/**
 * @author bp
 *
 */
public class PlacesPresenterImpl implements PlacesPresenter {

	private PlacesView view;

	@Inject
	public PlacesPresenterImpl(PlacesView view) {
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
