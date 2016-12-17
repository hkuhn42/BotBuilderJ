package org.sylvani.bot.connector.ms.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Attachment data
 **/

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name = "AttachmentData", propOrder =
	{ "type", "name", "originalBase64", "thumbnailBase64"
})

@XmlRootElement(name="AttachmentData")
public class AttachmentData  {
  

  @XmlElement(name="type")
  private String type = null;

  @XmlElement(name="name")
  private String name = null;

  @XmlElement(name="originalBase64")
  private byte[] originalBase64 = null;

  @XmlElement(name="thumbnailBase64")
  private byte[] thumbnailBase64 = null;

  /**
   * content type of the attachmnet
   **/
  
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  /**
   * Name of the attachment
   **/
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  /**
   * original content
   **/
  
  public byte[] getOriginalBase64() {
    return originalBase64;
  }
  public void setOriginalBase64(byte[] originalBase64) {
    this.originalBase64 = originalBase64;
  }
  /**
   * Thumbnail
   **/
  
  public byte[] getThumbnailBase64() {
    return thumbnailBase64;
  }
  public void setThumbnailBase64(byte[] thumbnailBase64) {
    this.thumbnailBase64 = thumbnailBase64;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachmentData {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    originalBase64: ").append(toIndentedString(originalBase64)).append("\n");
    sb.append("    thumbnailBase64: ").append(toIndentedString(thumbnailBase64)).append("\n");
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

