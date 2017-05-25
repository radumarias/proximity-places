package com.candor.bp.client.gin;

import com.candor.bp.client.presenter.PlacesPresenter;
/**
 * Factory that combines the caller's arguments with injector-supplied values to construct objects
 * with runtime parameters.
 * 
 * @author bp
 *
 */
public interface PlacesFactory {

	PlacesPresenter build(String cityId);

}