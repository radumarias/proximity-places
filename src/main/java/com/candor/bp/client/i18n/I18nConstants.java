package com.candor.bp.client.i18n;

/**
 * Interface to represent the constants contained in resource bundle:
 * 	'/home/bogdan/workspace/proximity-places/src/main/resources/com/candor/bp/client/i18n/I18nConstants.properties'.
 */
public interface I18nConstants extends com.google.gwt.i18n.client.Constants {
  
  /**
   * Translated "bp".
   * 
   * @return translated "bp"
   */
  @DefaultStringValue("bp")
  @Key("author")
  String author();

  /**
   * Translated "Closed".
   * 
   * @return translated "Closed"
   */
  @DefaultStringValue("Closed")
  @Key("closed")
  String closed();

  /**
   * Translated "Open Now".
   * 
   * @return translated "Open Now"
   */
  @DefaultStringValue("Open Now")
  @Key("open")
  String open();

  /**
   * Translated "Rating".
   * 
   * @return translated "Rating"
   */
  @DefaultStringValue("Rating")
  @Key("rating")
  String rating();

  /**
   * Translated "Requested resource is not available.".
   * 
   * @return translated "Requested resource is not available."
   */
  @DefaultStringValue("Requested resource is not available.")
  @Key("resourceNotAvailable")
  String resourceNotAvailable();
}
