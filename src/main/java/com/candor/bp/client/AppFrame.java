/**
 * 
 */
package com.candor.bp.client;

import java.util.logging.Level;

import com.candor.bp.client.event.ViewPlacesMapEvent;
import com.candor.bp.client.gin.AppGinjector;
import com.candor.bp.client.util.ClientLoggingUtils;
import com.candor.bp.client.view.PlacesView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.inject.Inject;

/**
 * Application main screen/socket/framework/skeleton/controller - all-in-one.
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

	@Inject
	@UiConstructor
	public AppFrame() {
		initWidget(uiBinder.createAndBindUi(this));
		bind();
	}

	/*
	 * Do binding.
	 */
	public void bind() {
		// handle bus events
		addEventBusHandlers();

		// add {@link History} events handler
		History.addValueChangeHandler(event -> onHistoryEvent(event));

		// do {@link History} initialization
		History.fireCurrentHistoryState();
	}

	/**
	 * Handle {@link History} events and navigation.
	 */
	public void onHistoryEvent(ValueChangeEvent<String> event) {
		/* Render {@link CityView} */
		if (Token.CITY.equals(History.getToken()) || History.getToken().isEmpty()) {
			/*
			 * Code Splitting performance driven choice
			 */
			GWT.runAsync(new RunAsyncCallback() {

				@Override
				public void onSuccess() {
					AppGinjector.INSTANCE.getCityPresenter().go(context);
				}
				@Override
				public void onFailure(Throwable reason) {
					ClientLoggingUtils.logToConsole(Level.SEVERE, reason.getMessage());
				}
			});

			// sync default view with {@link History} iff necessary
			if (History.getToken().isEmpty()) {
				History.newItem(Token.CITY, false);
			}

		}
		/* Render {@link PlacesView} */
		else if (Token.PLACES.equals(History.getToken())) {
			/*
			 * Code Splitting performance driven choice
			 */
			GWT.runAsync(new RunAsyncCallback() {

				@Override
				public void onSuccess() {
					AppGinjector.INSTANCE.getPlacesPresenter().go(context);
				}

				@Override
				public void onFailure(Throwable reason) {
					ClientLoggingUtils.logToConsole(Level.SEVERE, reason.getMessage());
				}
			});

		}
		/* Render {@link PlaceDetailsView} */
		else if (Token.PLACE_DETAILS.equals(History.getToken())) {
			/*
			 * Code Splitting performance driven choice
			 */
			GWT.runAsync(new RunAsyncCallback() {

				@Override
				public void onSuccess() {
					AppGinjector.INSTANCE.getPlaceDetailsPresenter().go(context);
				}

				@Override
				public void onFailure(Throwable reason) {
					ClientLoggingUtils.logToConsole(Level.SEVERE, reason.getMessage());
				}
			});

		}
		/* Render 'Resource not available' */
		else if (!History.getToken().isEmpty()) {
			context.setWidget(new HTML("<h2 style='text-align: center;'>" + AppGinjector.INSTANCE.getConstants().resourceNotAvailable() + "</h2>"));
		}
	}

	/**
	 * Register handlers on the BUS
	 */
	private void addEventBusHandlers() {

		AppGinjector.INSTANCE.getEventBus().addHandlerToSource(ViewPlacesMapEvent.TYPE, PlacesView.class, event -> {
			// show {@link PlacesMapView]
		});

	}

}
