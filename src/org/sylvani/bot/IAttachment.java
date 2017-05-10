/**
 * 
 */
package org.sylvani.bot;

import java.io.Serializable;
import java.net.URL;

/**
 * @author Harald Kuhn
 *
 */
public interface IAttachment extends Serializable {

	public AttachmentType getType();

	public long getSize();

	public String getName();

	public String getId();

	public URL getUrl();
}
