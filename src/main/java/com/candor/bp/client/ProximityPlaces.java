package com.candor.bp.client;

import com.candor.bp.client.gin.AppGinjector;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 * 
 * @author bp
 *
 */
public class ProximityPlaces extends AbstractEntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		/*
		 * Code Splitting performance driven choice
		 * 
		 * Render {@link AppFrame} framework.
		 */
		GWT.runAsync(AppFrame.class, new RunAsyncCallback() {

			@Override
			public void onSuccess() {
				setRootLayout(AppGinjector.INSTANCE.getAppFrame());
			}

			@Override
			public void onFailure(Throwable reason) {
				reason.printStackTrace();
			}
		});

	}
}
