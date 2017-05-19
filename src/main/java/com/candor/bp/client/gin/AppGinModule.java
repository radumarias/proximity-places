/**
 * 
 */
package com.candor.bp.client.gin;

import com.candor.bp.client.AppFrame;
import com.candor.bp.client.i18n.I18nConstants;
import com.candor.bp.client.i18n.I18nLookupConstants;
import com.candor.bp.client.i18n.I18nMessages;
import com.candor.bp.client.presenter.CityPresenter;
import com.candor.bp.client.presenter.PlaceDetailsPresenter;
import com.candor.bp.client.presenter.PlacesPresenter;
import com.candor.bp.client.presenter.impl.CityPresenterImpl;
import com.candor.bp.client.presenter.impl.PlaceDetailsPresenterImpl;
import com.candor.bp.client.presenter.impl.PlacesPresenterImpl;
import com.candor.bp.client.view.CityView;
import com.candor.bp.client.view.PlaceDetailsView;
import com.candor.bp.client.view.PlacesView;
import com.candor.bp.client.view.impl.CityViewImpl;
import com.candor.bp.client.view.impl.PlaceDetailsViewImpl;
import com.candor.bp.client.view.impl.PlacesViewImpl;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

/**
 * @author bp
 *
 */
public class AppGinModule extends AbstractGinModule {

	/* Prevent explicit instantiation. */
	private AppGinModule() {
		// nothing to do
	}

	// @Provides
	// @Singleton
	// public HandlerManager getEventBus() {
	// return new HandlerManager(null);
	// }

	/**
	 * Configure GIN i.e. {@link AbstractGinModule#configure()}
	 */
	@Override
	protected void configure() {
		/* bind the EventBus */
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);

		/* bind 18n {@link Constants} */
		bind(I18nConstants.class).in(Singleton.class);
		bind(I18nLookupConstants.class).in(Singleton.class);
		bind(I18nMessages.class).in(Singleton.class);

		/* bind views as {@link Singleton} */
		bind(CityView.class).to(CityViewImpl.class).in(Singleton.class);
		bind(PlacesView.class).to(PlacesViewImpl.class).in(Singleton.class);
		bind(PlaceDetailsView.class).to(PlaceDetailsViewImpl.class).in(Singleton.class);

		/* bind presenters */
		bind(CityPresenter.class).to(CityPresenterImpl.class);
		bind(PlacesPresenter.class).to(PlacesPresenterImpl.class);
		bind(PlaceDetailsPresenter.class).to(PlaceDetailsPresenterImpl.class);

		/* bind framework as {@link Singleton} */
		bind(AppFrame.class).in(Singleton.class);
	}

}
