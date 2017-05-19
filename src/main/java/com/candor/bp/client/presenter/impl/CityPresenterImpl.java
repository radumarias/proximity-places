/**
 * 
 */
package com.candor.bp.client.presenter.impl;

import com.candor.bp.client.presenter.CityPresenter;
import com.candor.bp.client.view.CityView;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.inject.Inject;

/**
 * @author bp
 *
 */
public class CityPresenterImpl implements CityPresenter {

	private CityView view;

	@Inject
	public CityPresenterImpl(CityView view) {
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
