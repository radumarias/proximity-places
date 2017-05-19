/**
 * 
 */
package com.candor.bp.client.view;

import com.candor.bp.client.presenter.PlaceDetailsPresenter;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author bp
 *
 */
public interface PlaceDetailsView extends IsWidget {
	void setPresenter(PlaceDetailsPresenter presenter);
}
