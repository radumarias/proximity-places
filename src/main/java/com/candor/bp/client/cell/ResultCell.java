package com.candor.bp.client.cell;

import com.candor.bp.client.gin.AppGinjector;
import com.candor.bp.client.google.place.model.ResultMO;
import com.candor.bp.client.google.place.model.json.OpeningHoursDTO;
import com.candor.bp.client.google.place.model.json.PhotoDTO;
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
import com.google.gwt.user.client.DOM;

/**
 * <b>Semantic XHTML5</b> Cell Template providing the means of rendering a {@link ResultMO}
 * instance.
 * 
 * @author bp
 *
 */
public class ResultCell extends AbstractCell<ResultMO> {

	private static long id;
	static {
		id = System.currentTimeMillis();
	}

	/*
	 * Action enumeration used for cell events handling.
	 */
	public static enum Action {
		/*
		 * detailed view logical event
		 */
		DETAILS;
	}

	/*
	 * Cell XHTML5 Template.
	 * 
	 */
	public interface Template extends SafeHtmlTemplates {
		//@formatter:off
		@Template("<div class='cell result'>"
				
						+ "<!-- header -->"
						+ "<header>"
							+ "<figure class='icon'>"
								+ "<img src='{0}' alt='icon'></img>"
							+ "</figure>"
							+ "<span class='types'>{1}</span>"
						+ "</header>"
							
						+ "<!-- body -->"
						+ "<section>"
							+ "<!-- left -->"
							+ "<aside class='left'>"
								+ "<figure class='photo'>"
									+ "<img id='{2}' alt='photo'></img>"
								+ "</figure>"
							+ "</aside>"
							+ "<!-- rigth -->"
							+ "<div class='right'>"
								+ "<h4 class='name'>{3}</h4>"
								+ "<p class='description'>{4}</p>"
								+ "<a target='_blank' href='{5}'>{5}</a>"
							+ "</div>"
						+ "</section>"
							
						+ "<!-- footer -->"
						+ "<footer>"
							+ "<div class='rating'>"
								+ "<em>{6}</em>"
								+ "<span>{7}</span>"
							+ "</div>"
							+ "<div class='openingHours'>"
								+ "{8}"
							+ "</div>"
						+ "</footer>"
				 + "</div>")
		//@formatter:on
		SafeHtml build(String iconUrl, String types, String photoElementId, String name, String description, String websiteUrl, String ratingLabel,
				double rating, String openingHours);
	}

	/*
	 * Safe XHTML5 Template instance.
	 */
	private Template template;

	/*
	 * Constructor method
	 */
	public ResultCell() {
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
	public void render(Context context, ResultMO value, SafeHtmlBuilder sb) {
		if (value != null) {
			final String photoElemId = String.valueOf(id);
			id++;

			sb.append(template.build(value.getIcon(), value.getTypes().toString(), photoElemId, value.getName(), value.getDescription(), value.getWebsite(),
					AppGinjector.INSTANCE.getConstants().rating(), value.getRating(), getOpeningHoursStatus(value.getOpening_hours())));

			// set photo URL in scope of a separate asynchronous call
			setPhotoUrl(value, photoElemId);

		}
	}

	/**
	 * Get open status.
	 * 
	 * @param opening_hours
	 * @return
	 */
	private String getOpeningHoursStatus(OpeningHoursDTO openingHours) {
		if (openingHours != null && openingHours.isOpen_now()) {
			return AppGinjector.INSTANCE.getConstants().open();
		}

		return AppGinjector.INSTANCE.getConstants().closed();
	}

	/**
	 * XMLHttpRequest to get and set the photo URL.
	 * 
	 * @param value
	 * @param photoElemId
	 */
	private void setPhotoUrl(ResultMO value, final String photoElemId) {
		/*
		 * photos[] may contain, in this case, MAX 1 photo w.r.p.t. Google Place API specifications
		 */
		if (value.getPhotos().length > 0) {
			final PhotoDTO photoDto = value.getPhotos()[0];
			//@formatter:off
			AppGinjector.INSTANCE.getDataManager().getPlacePhoto(
															photoUrl -> DOM.getElementById(photoElemId).setAttribute("src", photoUrl),
															photoDto.getPhotoReference(), 
															photoDto.getWidth());
			//@formatter:on
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
	public void onBrowserEvent(Context context, Element parent, ResultMO value, NativeEvent event, ValueUpdater<ResultMO> valueUpdater) {
		super.onBrowserEvent(context, parent, value, event, valueUpdater);

		// persist transient action for upstream handling
		value.setAction(Action.DETAILS.toString());

		// announce update
		valueUpdater.update(value);
	}

}
