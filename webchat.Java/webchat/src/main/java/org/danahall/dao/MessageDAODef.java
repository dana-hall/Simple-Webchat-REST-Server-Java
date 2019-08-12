package org.danahall.dao;

import org.danahall.dto.requests.CreateRequestMessage;
import org.danahall.dto.requests.DeleteRequestMessage;
import org.danahall.dto.requests.UpdateRequestMessage;
import org.danahall.dto.responses.CreateResponseMessage;
import org.danahall.dto.responses.DeleteResponseMessage;
import org.danahall.dto.responses.ReadResponseMessage;
import org.danahall.dto.responses.UpdateResponseMessage;
import org.springframework.web.bind.annotation.RequestBody;

public interface MessageDAODef {

	//
	// Create a message
	//
	public CreateResponseMessage createMessage(CreateRequestMessage message);

	//
	// Delete all messages
	//
	public DeleteResponseMessage deleteMessages(@RequestBody DeleteRequestMessage req);

	//
	// Update a message
	//
	public UpdateResponseMessage updateMessage(String id, UpdateRequestMessage req);

	//
	// Retrieve all messages belonging to a user
	//
	public ReadResponseMessage fetchUserMessages(String user);

	//
	// Retrieve all messages from a user
	//
	public ReadResponseMessage fetchMessagesFromUser(String user);

	//
	// Fetch all messages from a user to a user
	//
	public ReadResponseMessage fetchMessagesFromUserToUser(String fromUser, String toUser);

	//
	// Fetch all the messages in the table
	//
	public ReadResponseMessage fetchAllMessages();

}
