package org.sylvani.bot.connector.ms.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Channel account information needed to route a message
 **/

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name = "ChannelAccount", propOrder =
	{ "id", "name"
})

@XmlRootElement(name="ChannelAccount")
public class ChannelAccount  {
  

  @XmlElement(name="id")
  private String id = null;

  @XmlElement(name="name")
  private String name = null;

  /**
   * Channel id for the user or bot on this channel (Example: joe@smith.com, or @joesmith or 123456)
   **/
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  /**
   * Display friendly name
   **/
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelAccount {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
