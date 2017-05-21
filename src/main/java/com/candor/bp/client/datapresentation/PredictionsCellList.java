/**
 * 
 */
package com.candor.bp.client.datapresentation;

import java.util.List;

import com.candor.bp.client.cell.PredictionCell;
import com.candor.bp.client.cell.PredictionCell.Action;
import com.candor.bp.client.datapresentation.style.CellListResources;
import com.candor.bp.client.event.SelectPlaceEvent;
import com.candor.bp.client.gin.AppGinjector;
import com.candor.bp.client.google.place.model.PredictionMO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.NoSelectionModel;

/**
 * Cell List class providing the means for low-level & fast rendering of a {@link PredictionMO}
 * collection.
 * 
 * @author bp
 *
 */
public class PredictionsCellList extends CellList<PredictionMO> {

	/* data source */
	private ListDataProvider<PredictionMO> dataProvider;

	/**
	 * Construct a new {@link PredictionsCellList}.
	 */
	public PredictionsCellList() {
		super(new PredictionCell(), (CellList.Resources) GWT.create(CellListResources.class));
		bind();
	}

	/**
	 * Do components initialization.
	 */
	private void bind() {
		/* set page size to 5, as Google Places API Web Service returns up to 5 predictions */
		setPageSize(5);

		// list data source
		dataProvider = new ListDataProvider<PredictionMO>();

		// connect the CellList to the data provider
		dataProvider.addDataDisplay(this);

		// set value updater
		setValueUpdater(value -> onValueUpdate(value));

		// no selection model & disable SelectionChangeEvent
		setSelectionModel(new NoSelectionModel<PredictionMO>(), DefaultSelectionEventManager.<PredictionMO> createWhitelistManager());

		// enable keyboard selection/navigation
		setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

	}

	/**
	 * Handles cell update events.
	 * 
	 * @param handler
	 *            {@link PredictionMO} instance
	 */
	private void onValueUpdate(PredictionMO handler) {
		// Click Event

		if (Action.SELECT.toString() == handler.getAction()) {
			/* fire {@link SelectPlaceEvent} -> will be handler upstream */
			AppGinjector.INSTANCE.getEventBus().fireEventFromSource(new SelectPlaceEvent(handler.getPlaceId()), PredictionsCellList.class);
		}
	}

	/**
	 * Refresh cell list data.
	 * 
	 * @param users
	 *            {@link PredictionMO} collection
	 */
	public void refreshData(List<PredictionMO> predctions) {

		// clear {@link dataProvider#list}
		dataProvider.getList().clear();

		// add new users to {@link dataProvider#list}
		dataProvider.getList().addAll(predctions);

		// refresh display
		dataProvider.refresh();
	}

}
