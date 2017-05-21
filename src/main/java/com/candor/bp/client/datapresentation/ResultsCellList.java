package com.candor.bp.client.datapresentation;

import java.util.ArrayList;
import java.util.List;

import com.candor.bp.client.cell.ResultCell;
import com.candor.bp.client.cell.ResultCell.Action;
import com.candor.bp.client.datapresentation.style.CellListResources;
import com.candor.bp.client.gin.AppGinjector;
import com.candor.bp.client.google.place.model.ResultMO;
import com.candor.bp.client.google.place.model.json.CoordinateDTO;
import com.candor.bp.client.google.place.model.json.NearbyPlacesDTO;
import com.candor.bp.client.google.place.model.json.ResultDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.NoSelectionModel;
import com.google.gwt.view.client.Range;

/**
 * Cell List class providing the means for low-level & fast rendering of a {@link ResultMO}
 * collection.
 * 
 * @author bp
 *
 */
public class ResultsCellList extends CellList<ResultMO> {

	/* data source */
	private AsyncDataProvider<ResultMO> dataProvider;

	/*
	 * # of items to be fetch per page; Google Places API Web Service returns up to 20 results
	 */
	private final int rangeSize;

	/* next page token */
	private String nextPageToken = null;

	/* coordinates */
	private CoordinateDTO location;

	/* keyword */
	private String keyword;

	/* {@link PlaceType#typeName} collection */
	private List<String> types;

	/**
	 * Construct a new {@link ResultsCellList}
	 * 
	 * @param rangeSize
	 */
	public ResultsCellList(int rangeSize, CoordinateDTO location) {
		super(new ResultCell(), (CellList.Resources) GWT.create(CellListResources.class));
		this.rangeSize = rangeSize;
		this.location = location;
		bind();
	}

	private void bind() {
		/* set page size */
		setPageSize(rangeSize);

		/*
		 * Create a {@link AsyncDataProvider} instance and set it as data source for this {@link
		 * ResultsCellList}
		 */
		dataProvider = new AsyncDataProvider<ResultMO>() {

			@Override
			protected void onRangeChanged(HasData<ResultMO> display) {
				/*
				 * On Range Changed Event: fetch and append the next chunk of {@link
				 * NearbyPlacesDTO}
				 */
				fetchAndRefreshhData();
			}
		};

		// connect the CellList to the data provider
		dataProvider.addDataDisplay(this);

		// set value updater
		setValueUpdater(value -> onValueUpdate(value));

		// no selection model & disable SelectionChangeEvent
		setSelectionModel(new NoSelectionModel<ResultMO>(), DefaultSelectionEventManager.<ResultMO> createWhitelistManager());

		// disable keyboard selection/navigation
		setKeyboardSelectionPolicy(KeyboardSelectionPolicy.DISABLED);

	}

	/**
	 * Handles cell update events.
	 * 
	 * @param handler
	 *            {@link ResultMO} instance
	 */
	private void onValueUpdate(ResultMO handler) {
		// Click Event

		if (Action.DETAILS.toString() == handler.getAction()) {
			/* fire {@link History#newItem} -> will be handler upstream */
		}
	}

	/**
	 * Fetch and refresh data: fetch and append next data chunk.
	 */
	private void fetchAndRefreshhData() {
		// fetch first range
		if (nextPageToken == null) {
			AppGinjector.INSTANCE.getDataManager().getNearbyPlaces(nearbyPlaces -> refreshData(nearbyPlaces), location, 5000, keyword, types);
		}
		// fetch next range
		else {
			AppGinjector.INSTANCE.getDataManager().getNearbyPlacesNextPage(nearbyPlaces -> refreshData(nearbyPlaces), nextPageToken);
		}
	}

	/**
	 * Refresh data.
	 * 
	 * 
	 * @param nearbyPlaces
	 *            {@link NearbyPlacesDTO}
	 */
	private void refreshData(NearbyPlacesDTO nearbyPlaces) {

		/* Convert Array to {@link List} */
		final List<ResultMO> results = new ArrayList<ResultMO>(nearbyPlaces.getResults().length);
		for (ResultDTO dto : nearbyPlaces.getResults()) {
			results.add(new ResultMO(dto));
		}

		/* refresh presenter data */
		HasDataUtils.refreshPresenter(this, results, getVisibleItemCount(), (getVisibleItemCount() + results.size()));

		/* update {@link #nextPageToken} */
		nextPageToken = nearbyPlaces.getNextPageToken();
	}

	/**
	 * Reset visible {@link Range} and clear presenter data.
	 */
	public void resetVisibleRangeAndClearData(String keyword, List<String> types) {
		// reset {@link #nextPageToken}
		nextPageToken = null;

		// set {@link #keyword}
		this.keyword = keyword;

		// set {@link #places}
		this.types = types;

		// reset visible {@link Range} and clear presenter data
		setVisibleRangeAndClearData(new Range(0, rangeSize), true);
	}

	/**
	 * Triggers {@link #onRangeChanged} to fetch a new page of {@link ResultMO} items.
	 */
	public void nextRange() {
		setVisibleRange(getVisibleRange().getStart(), rangeSize);
	}

}
