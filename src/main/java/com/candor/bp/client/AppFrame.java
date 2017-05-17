/**
 * 
 */
package com.candor.bp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Application main screen/socket/framework/skeleton.
 * 
 * @author bp
 *
 */
public class AppFrame extends ResizeComposite {

	private static AppFrameUiBinder uiBinder = GWT.create(AppFrameUiBinder.class);

	interface AppFrameUiBinder extends UiBinder<SimpleLayoutPanel, AppFrame> {
	}

	@UiField
	SimpleLayoutPanel context;

	/**
	 * Because this class has a default constructor, it can be used as a binder template. In other words, it can be used in other *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder" xmlns:g=
	 * "urn:import:**user's package**" > <g:**UserClassName**>Hello!</g:**UserClassName> </ui:UiBinder> Note that depending on the widget that is used, it may
	 * be necessary to implement HasHTML instead of HasText.
	 */
	public AppFrame() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	/**
	 * 
	 * @return
	 */
	protected SimpleLayoutPanel getContext() {
		return context;
	}

	/**
	 * 
	 * @param widget
	 */
	protected void setContext(Widget widget) {
		context.setWidget(widget);
	}

}
