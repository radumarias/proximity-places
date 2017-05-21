package com.candor.bp.client.datapresentation.style;

import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellList.Resources;
import com.google.gwt.user.cellview.client.CellList.Style;

/**
 * {@link CellList} CSS Style interface.
 * 
 * @author bp
 *
 */
interface CellListStyle extends Style {
	// marker interface - nothing to do
}

/**
 * {@link CellList} CSS Resource interface.
 * 
 * @author bp
 *
 */
public interface CellListResources extends Resources {
	@Override
	@Source({"CellListStyle.css"})
	CellListStyle cellListStyle();
}
