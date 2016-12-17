package org.sylvani.bot.connector.ms.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Object describing a media thumbnail
 **/

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name = "ThumbnailUrl", propOrder =
	{ "url", "alt"
})

@XmlRootElement(name="ThumbnailUrl")
public class ThumbnailUrl  {
  

  @XmlElement(name="url")
  private String url = null;

  @XmlElement(name="alt")
  private String alt = null;

  /**
   * url pointing to an thumbnail to use for media content
   **/
  
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
  /**
   * Alt text to display for screen readers on the thumbnail image
   **/
  
  public String getAlt() {
    return alt;
  }
  public void setAlt(String alt) {
    this.alt = alt;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ThumbnailUrl {\n");
    
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    alt: ").append(toIndentedString(alt)).append("\n");
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

