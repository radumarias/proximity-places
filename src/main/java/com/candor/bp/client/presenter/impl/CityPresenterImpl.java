/**
 * 
 */
package com.candor.bp.client.presenter.impl;

import java.util.ArrayList;
import java.util.List;

import com.candor.bp.client.Token;
import com.candor.bp.client.datapresentation.PredictionsCellList;
import com.candor.bp.client.event.SelectPlaceEvent;
import com.candor.bp.client.gin.AppGinjector;
import com.candor.bp.client.google.place.model.PredictionMO;
import com.candor.bp.client.google.place.model.json.PredictionDTO;
import com.candor.bp.client.presenter.CityPresenter;
import com.candor.bp.client.view.CityView;
import com.google.gwt.user.client.History;
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
		addEventBusHandlers();
	}

	/**
	 * Register handlers on the BUS
	 */
	private void addEventBusHandlers() {

		AppGinjector.INSTANCE.getEventBus().addHandlerToSource(SelectPlaceEvent.TYPE, PredictionsCellList.class, event -> {
			History.newItem(Token.PLACES + "?cityid=" + event.getPlaceId());
		});

	}

	@Override
	public void onSearchBoxKeyUpEvent(String value) {
		AppGinjector.INSTANCE.getDataManager().getCityPredictions(predictions -> {
			final List<PredictionMO> cityList = new ArrayList<PredictionMO>(predictions.length);
			for (PredictionDTO prediction : predictions) {
				cityList.add(new PredictionMO(prediction));
			}
			view.getSuggestList().refreshData(cityList);
		}, value);
	}

}
