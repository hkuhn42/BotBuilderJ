package org.sylvani.bot.connector.ms;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * 
 * @author Harald Kuhn
 *
 */
@Path("/")
public interface AttachmentsApi {
	@GET
	@Path("/v3/attachments/{attachmentId}/views/{viewId}")

	@Produces({ "application/json", "text/json", "application/xml", "text/xml" })
	public Response attachmentsGetAttachment(@PathParam("attachmentId") String attachmentId,
			@PathParam("viewId") String viewId);

	@GET
	@Path("/v3/attachments/{attachmentId}")

	@Produces({ "application/json", "text/json", "application/xml", "text/xml" })
	public Response attachmentsGetAttachmentInfo(@PathParam("attachmentId") String attachmentId);
}
