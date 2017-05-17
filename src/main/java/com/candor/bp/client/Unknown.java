/**
 * 
 */
package com.candor.bp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;

/**
 * {@link EntryPoint} implementation handling all unknown rendering engines.
 * 
 * @author bp
 *
 */
public class Unknown extends AbstractEntryPoint {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	@Override
	public void onModuleLoad() {
		setRootLayout(new HTML("<h1>Sorry, your rendering engine is not supported!</h1>"));
	}

}
