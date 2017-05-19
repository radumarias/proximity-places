/**
 * 
 */
package com.candor.bp.client.presenter.impl;

import com.candor.bp.client.presenter.PlaceDetailsPresenter;
import com.candor.bp.client.view.PlaceDetailsView;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.inject.Inject;

/**
 * @author bp
 *
 */
public class PlaceDetailsPresenterImpl implements PlaceDetailsPresenter {

	private PlaceDetailsView view;

	/**
	 * @param view
	 */
	@Inject
	public PlaceDetailsPresenterImpl(PlaceDetailsView view) {
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
