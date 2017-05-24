/**
 * 
 */
package com.candor.bp.client.view.impl;

import com.candor.bp.client.datapresentation.PredictionsCellList;
import com.candor.bp.client.presenter.CityPresenter;
import com.candor.bp.client.view.CityView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * @author bp
 *
 */
public class CityViewImpl extends Composite implements CityView {

	private static CityViewImplUiBinder uiBinder = GWT.create(CityViewImplUiBinder.class);

	interface CityViewImplUiBinder extends UiBinder<HTMLPanel, CityViewImpl> {
	}

	@UiField
	protected TextBox searchBox;

	@UiField
	protected PredictionsCellList suggestList;

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
		initComponents();
	}

	private void initComponents() {
		searchBox.getElement().setAttribute("placeholder", "Type your city....");

	}

	@Override
	public void setPresenter(CityPresenter presenter) {
		this.presenter = presenter;

	}

	@UiHandler(value = "searchBox")
	void onKeyUp(KeyUpEvent event) {
		presenter.onSearchBoxKeyUpEvent(searchBox.getValue().trim());
	}

	@Override
	public TextBox getSearchBox() {
		return searchBox;
	}

	@Override
	public PredictionsCellList getSuggestList() {
		return suggestList;
	}

}
