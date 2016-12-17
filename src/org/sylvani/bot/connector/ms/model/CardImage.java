package org.sylvani.bot.connector.ms.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * An image on a card
 **/

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name = "CardImage", propOrder =
	{ "url", "alt", "tap"
})

@XmlRootElement(name="CardImage")
public class CardImage  {
  

  @XmlElement(name="url")
  private String url = null;

  @XmlElement(name="alt")
  private String alt = null;

  @XmlElement(name="tap")
  private CardAction tap = null;

  /**
   * URL Thumbnail image for major content property.
   **/
  
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
  /**
   * Image description intended for screen readers
   **/
  
  public String getAlt() {
    return alt;
  }
  public void setAlt(String alt) {
    this.alt = alt;
  }
  /**
   * Action assigned to specific Attachment.E.g.navigate to specific URL or play/open media content
   **/
  
  public CardAction getTap() {
    return tap;
  }
  public void setTap(CardAction tap) {
    this.tap = tap;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CardImage {\n");
    
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    alt: ").append(toIndentedString(alt)).append("\n");
    sb.append("    tap: ").append(toIndentedString(tap)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

