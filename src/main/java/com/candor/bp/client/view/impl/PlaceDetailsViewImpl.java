/**
 * 
 */
package com.candor.bp.client.view.impl;

import com.candor.bp.client.presenter.PlaceDetailsPresenter;
import com.candor.bp.client.view.PlaceDetailsView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * @author bp
 *
 */
public class PlaceDetailsViewImpl extends Composite implements PlaceDetailsView {

	private static PlaceDetailsViewImplUiBinder uiBinder = GWT.create(PlaceDetailsViewImplUiBinder.class);

	interface PlaceDetailsViewImplUiBinder extends UiBinder<HTMLPanel, PlaceDetailsViewImpl> {
	}

	private PlaceDetailsPresenter presenter;

	/**
	 * Because this class has a default constructor, it can be used as a binder template. In other
	 * words, it can be used in other *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder" xmlns:g=
	 * "urn:import:**user's package**" > <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder> Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	public PlaceDetailsViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(PlaceDetailsPresenter presenter) {
		this.presenter = presenter;

	}

}
