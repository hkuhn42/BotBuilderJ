package org.sylvani.bot.connector.ms.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Attachment View name and size
 **/

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name = "AttachmentView", propOrder =
	{ "viewId", "size"
})

@XmlRootElement(name="AttachmentView")
public class AttachmentView  {
  

  @XmlElement(name="viewId")
  private String viewId = null;

  @XmlElement(name="size")
  private Integer size = null;

  /**
   * content type of the attachmnet
   **/
  
  public String getViewId() {
    return viewId;
  }
  public void setViewId(String viewId) {
    this.viewId = viewId;
  }
  /**
   * Name of the attachment
   **/
  
  public Integer getSize() {
    return size;
  }
  public void setSize(Integer size) {
    this.size = size;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachmentView {\n");
    
    sb.append("    viewId: ").append(toIndentedString(viewId)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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

