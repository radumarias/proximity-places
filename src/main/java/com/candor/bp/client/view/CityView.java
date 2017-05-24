/**
 * 
 */
package com.candor.bp.client.view;

import com.candor.bp.client.datapresentation.PredictionsCellList;
import com.candor.bp.client.presenter.CityPresenter;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextBox;

/**
 * @author bp
 *
 */
public interface CityView extends IsWidget {

	void setPresenter(CityPresenter presenter);

	TextBox getSearchBox();

	PredictionsCellList getSuggestList();
}
