package com.candor.bp.client.cell;

import com.candor.bp.client.google.place.model.PredictionMO;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.client.SafeHtmlTemplates.Template;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

/**
 * XHTML Cell Template Class providing the means of rendering a {@link PredisctionMO} instance.
 * 
 * @author bp
 *
 */
public class PredictionCell extends AbstractCell<PredictionMO> {

	/*
	 * Action enumeration used for cell events handling.
	 */
	public static enum Action {
		/*
		 * select logical event
		 */
		SELECT;
	}

	/*
	 * Cell XHTML Template.
	 * 
	 */
	public interface Template extends SafeHtmlTemplates {
		//@formatter:off
		@Template("<div class='cell prediction'>"
						+ "<section class='content'>"
							+ "<p>{0}</p>"
						+ "</section>"
				 + "</div>")
		//@formatter:on
		SafeHtml build(String description);
	}

	/*
	 * Safe XHTML Template instance.
	 */
	private Template template;

	/*
	 * Constructor method
	 */
	public PredictionCell() {
		/*
		 * register for consuming click events
		 */
		super(BrowserEvents.CLICK);

		// instantiate Safe HTML Template
		if (template == null) {
			template = GWT.create(Template.class);
		}
	}

	/*
	 * HTML render method.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.google.gwt.cell.client.AbstractCell#render(com.google.gwt.cell.client .Cell.Context,
	 * java.lang.Object, com.google.gwt.safehtml.shared.SafeHtmlBuilder)
	 */
	@Override
	public void render(Context context, PredictionMO value, SafeHtmlBuilder sb) {
		if (value != null) {
			sb.append(template.build(value.getDescription()));

			// other asynchronous workers may be added here
		}
	}

	/*
	 * Handle Browser Event(s).
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.google.gwt.cell.client.AbstractCell#onBrowserEvent(com.google.gwt.
	 * cell.client.Cell.Context, com.google.gwt.dom.client.Element, java.lang.Object,
	 * com.google.gwt.dom.client.NativeEvent, com.google.gwt.cell.client.ValueUpdater)
	 */
	@Override
	public void onBrowserEvent(Context context, Element parent, PredictionMO value, NativeEvent event, ValueUpdater<PredictionMO> valueUpdater) {
		super.onBrowserEvent(context, parent, value, event, valueUpdater);

		// persist transient action for upstream handling
		value.setAction(Action.SELECT.toString());

		// announce update
		valueUpdater.update(value);
	}

}