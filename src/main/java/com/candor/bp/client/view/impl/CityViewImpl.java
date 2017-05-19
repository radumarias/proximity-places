/**
 * 
 */
package com.candor.bp.client.view.impl;

import com.candor.bp.client.presenter.CityPresenter;
import com.candor.bp.client.view.CityView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * @author bp
 *
 */
public class CityViewImpl extends Composite implements CityView {

	private static CityViewImplUiBinder uiBinder = GWT.create(CityViewImplUiBinder.class);

	interface CityViewImplUiBinder extends UiBinder<HTMLPanel, CityViewImpl> {
	}

	private CityPresenter presenter;

	/**
	 * Because this class has a default constructor, it can be used as a binder template. In other
	 * words, it can be used in other *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder" xmlns:g=
	 * "urn:import:**user's package**" > <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder> Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	public CityViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(CityPresenter presenter) {
		this.presenter = presenter;

	}

}
