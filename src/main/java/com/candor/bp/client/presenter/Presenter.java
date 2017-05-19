package com.candor.bp.client.presenter;

import com.google.gwt.user.client.ui.HasOneWidget;
/**
 * Marker Presenter interface.
 * 
 * @author bp
 *
 */
public interface Presenter {
	public void go(final HasOneWidget container);
	public void bind();
}
