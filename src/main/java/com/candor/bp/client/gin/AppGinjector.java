/**
 * 
 */
package com.candor.bp.client.gin;

import com.candor.bp.client.AppFrame;
import com.candor.bp.client.DataManager;
import com.candor.bp.client.i18n.I18nConstants;
import com.candor.bp.client.i18n.I18nLookupConstants;
import com.candor.bp.client.i18n.I18nMessages;
import com.candor.bp.client.presenter.CityPresenter;
import com.candor.bp.client.presenter.PlaceDetailsPresenter;
import com.candor.bp.client.presenter.PlacesMapPresenter;
import com.candor.bp.client.presenter.PlacesPresenter;
import com.candor.bp.client.view.CityView;
import com.candor.bp.client.view.PlaceDetailsView;
import com.candor.bp.client.view.PlacesMapView;
import com.candor.bp.client.view.PlacesView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * @author bp
 *
 */
@GinModules(AppGinModule.class)
public interface AppGinjector extends Ginjector {

	/* {@link AppGinjector} compile time constant */
	public static final AppGinjector INSTANCE = GWT.create(AppGinjector.class);

	// event bus
	EventBus getEventBus();

	// i18n
	I18nConstants getConstants();
	I18nLookupConstants getLookupConstants();
	I18nMessages getMessages();

	// view
	CityView getCityView();
	PlacesView getPlacesView();
	PlaceDetailsView getPlaceDetailsView();
	PlacesMapView getPlacesMapView();

	// presenter
	CityPresenter getCityPresenter();
	PlacesPresenter getPlacesPresenter();
	PlaceDetailsPresenter getPlaceDetailsPresenter();
	PlacesMapPresenter getPlacesMapPresnter();

	// framework
	AppFrame getAppFrame();

	// data manager
	DataManager getDataManager();
}
