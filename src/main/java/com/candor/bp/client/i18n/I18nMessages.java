package com.candor.bp.client.i18n;

/**
 * Interface to represent i18n messages.
 * 
 * @author bp
 *
 */
public interface I18nMessages extends com.google.gwt.i18n.client.Messages {

	/**
	 * Translated "bp".
	 * 
	 * @return translated "bp"
	 */
	@DefaultMessage("bp")
	@Key("author")
	String author();

	/**
	 * Translated "{0} places".
	 * 
	 * @return translated "{0} places"
	 */
	@DefaultMessage("{0,number} places")
	@AlternateMessage({"=1", "{0} place"})
	@Key("placeCount")
	String placeCount(@PluralCount int arg0);

	/**
	 * Translated "Sorry, your rendering engine - {0} - is not supported!".
	 * 
	 * @param arg0
	 * @return ranslated "Sorry, your rendering engine - {0} - is not supported!"
	 */
	@DefaultMessage("Sorry, your rendering engine - {0} - is not supported!")
	@Key("browserNotSupported")
	String browserNotSupported(String arg0);
}
