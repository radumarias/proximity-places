/**
 * 
 */
package com.candor.bp.client.view;

import com.candor.bp.client.presenter.CityPresenter;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author bp
 *
 */
public interface CityView extends IsWidget {
	void setPresenter(CityPresenter presenter);
}
