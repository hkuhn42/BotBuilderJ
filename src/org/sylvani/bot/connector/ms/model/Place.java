package org.sylvani.bot.connector.ms.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Place (entity type: \&quot;https://schema.org/Place\&quot;)
 **/

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name = "Place", propOrder =
	{ "address", "geo", "hasMap", "type", "name"
})

@XmlRootElement(name="Place")
public class Place  {
  

  @XmlElement(name="address")
  private Object address = null;

  @XmlElement(name="geo")
  private Object geo = null;

  @XmlElement(name="hasMap")
  private Object hasMap = null;

  @XmlElement(name="type")
  private String type = null;

  @XmlElement(name="name")
  private String name = null;

  /**
   * Address of the place (may be `string` or complex object of type `PostalAddress`)
   **/
  
  public Object getAddress() {
    return address;
  }
  public void setAddress(Object address) {
    this.address = address;
  }
  /**
   * Geo coordinates of the place (may be complex object of type `GeoCoordinates` or `GeoShape`)
   **/
  
  public Object getGeo() {
    return geo;
  }
  public void setGeo(Object geo) {
    this.geo = geo;
  }
  /**
   * Map to the place (may be `string` (URL) or complex object of type `Map`)
   **/
  
  public Object getHasMap() {
    return hasMap;
  }
  public void setHasMap(Object hasMap) {
    this.hasMap = hasMap;
  }
  /**
   * The type of the thing
   **/
  
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  /**
   * The name of the thing
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
    sb.append("class Place {\n");
    
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    geo: ").append(toIndentedString(geo)).append("\n");
    sb.append("    hasMap: ").append(toIndentedString(hasMap)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

