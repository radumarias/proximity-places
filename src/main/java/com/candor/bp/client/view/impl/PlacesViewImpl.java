/**
 * 
 */
package com.candor.bp.client.view.impl;

import com.candor.bp.client.presenter.PlacesPresenter;
import com.candor.bp.client.view.PlacesView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * @author bp
 *
 */
public class PlacesViewImpl extends Composite implements PlacesView {

	private static PlacesViewImplUiBinder uiBinder = GWT.create(PlacesViewImplUiBinder.class);

	interface PlacesViewImplUiBinder extends UiBinder<HTMLPanel, PlacesViewImpl> {
	}

	private PlacesPresenter presenter;

	/**
	 * Because this class has a default constructor, it can be used as a binder template. In other
	 * words, it can be used in other *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder" xmlns:g=
	 * "urn:import:**user's package**" > <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder> Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	public PlacesViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(PlacesPresenter presenter) {
		this.presenter = presenter;

	}

}
