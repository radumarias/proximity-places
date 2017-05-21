package com.candor.bp.client.datapresentation;

import java.util.List;

import com.google.gwt.view.client.HasData;

/**
 * Utility class (not inheritable) to provide convenience methods for working with data-presentation
 * (cell) widget types.
 * 
 * @author bp
 * 
 */
public final class HasDataUtils {

	/* Prevent instantiation. */
	private HasDataUtils() {
		/*
		 * Just in case new instance is created inside the class and/or through GWT.create(), DI
		 */
		throw new AssertionError(getClass().getName() + " utility class cannot be instatiated.");
	}

	/**
	 * Refresh {@link HasData} presenter.
	 * 
	 * @param presenter
	 * @param data
	 * @param start
	 * @param size
	 */
	public static <T> void refreshPresenter(HasData<T> presenter, List<T> data, int start, int size) {
		presenter.setRowCount(size);
		presenter.setRowData(start, data);
	}

}
