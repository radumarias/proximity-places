/**
 * 
 */
package com.candor.bp.client.view;

import com.candor.bp.client.presenter.PlacesPresenter;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author bp
 *
 */
public interface PlacesView extends IsWidget {
	void setPresenter(PlacesPresenter presenter);
}
