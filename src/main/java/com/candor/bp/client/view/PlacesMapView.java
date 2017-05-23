/**
 * 
 */
package com.candor.bp.client.view;

import com.candor.bp.client.presenter.PlacesMapPresenter;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author bp
 *
 */
public interface PlacesMapView extends IsWidget {
	void setPresenter(PlacesMapPresenter presenter);
}
