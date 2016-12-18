package org.sylvani.bot.connector.ms;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.sylvani.bot.connector.ms.model.Activity;
import org.sylvani.bot.connector.ms.model.AttachmentData;
import org.sylvani.bot.connector.ms.model.ConversationParameters;

/**
 * MS Conversation api genrated from swagger file
 * 
 * @author Harald Kuhn
 */
@Path("/")
public interface ConversationsApi {
	@POST
	@Path("/v3/conversations")
	@Consumes({ "application/json", "text/json", "application/xml", "text/xml", "application/x-www-form-urlencoded" })
	@Produces({ "application/json", "text/json", "application/xml", "text/xml" })
	public Response conversationsCreateConversation(ConversationParameters parameters);

	@DELETE
	@Path("/v3/conversations/{conversationId}/activities/{activityId}")

	@Produces({ "application/json", "text/json", "application/xml", "text/xml" })
	public Response conversationsDeleteActivity(@PathParam("conversationId") String conversationId,
			@PathParam("activityId") String activityId);

	@GET
	@Path("/v3/conversations/{conversationId}/activities/{activityId}/members")

	@Produces({ "application/json", "text/json", "application/xml", "text/xml" })
	public Response conversationsGetActivityMembers(@PathParam("conversationId") String conversationId,
			@PathParam("activityId") String activityId);

	@GET
	@Path("/v3/conversations/{conversationId}/members")

	@Produces({ "application/json", "text/json", "application/xml", "text/xml" })
	public Response conversationsGetConversationMembers(@PathParam("conversationId") String conversationId);

	@POST
	@Path("/v3/conversations/{conversationId}/activities/{activityId}")
	@Consumes({ "application/json", "text/json", "application/xml", "text/xml", "application/x-www-form-urlencoded" })
	@Produces({ "application/json", "text/json" })
	public Response conversationsReplyToActivity(@PathParam("conversationId") String conversationId,
			@PathParam("activityId") String activityId, Activity activity);

	@POST
	@Path("/v3/conversations/{conversationId}/activities")
	@Consumes({ "application/json", "text/json", "application/xml", "text/xml", "application/x-www-form-urlencoded" })
	@Produces({ "application/json", "text/json" })
	public Response conversationsSendToConversation(Activity activity,
			@PathParam("conversationId") String conversationId);

	@PUT
	@Path("/v3/conversations/{conversationId}/activities/{activityId}")
	@Consumes({ "application/json", "text/json", "application/xml", "text/xml", "application/x-www-form-urlencoded" })
	@Produces({ "application/json", "text/json" })
	public Response conversationsUpdateActivity(@PathParam("conversationId") String conversationId,
			@PathParam("activityId") String activityId, Activity activity);

	@POST
	@Path("/v3/conversations/{conversationId}/attachments")
	@Consumes({ "application/json", "text/json", "application/xml", "text/xml", "application/x-www-form-urlencoded" })
	@Produces({ "application/json", "text/json" })
	public Response conversationsUploadAttachment(@PathParam("conversationId") String conversationId,
			AttachmentData attachmentUpload);
}