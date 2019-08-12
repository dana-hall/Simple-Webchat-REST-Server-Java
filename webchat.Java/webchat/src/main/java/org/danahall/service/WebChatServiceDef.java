package org.danahall.service;

import org.danahall.dto.requests.CreateRequestMessage;
import org.danahall.dto.requests.DeleteRequestMessage;
import org.danahall.dto.requests.UpdateRequestMessage;
import org.danahall.dto.responses.CreateResponseMessage;
import org.danahall.dto.responses.DeleteResponseMessage;
import org.danahall.dto.responses.ReadResponseMessage;
import org.danahall.dto.responses.UpdateResponseMessage;

public interface WebChatServiceDef {
	//
	// Create a message
	//
	CreateResponseMessage createMessage(CreateRequestMessage req);

	//
	// Delete all messages
	//
	DeleteResponseMessage deleteMessages(DeleteRequestMessage req);

	//
	// Update a message
	//
	UpdateResponseMessage updateMessage(String id, UpdateRequestMessage req);

	//
	// Retrieve all messages belonging to a user
	//
	ReadResponseMessage fetchUserMessages(String user);

	//
	// Retrieve all messages from a user
	//
	ReadResponseMessage fetchMessagesFromUser(String user);

	//
	// Fetch all messages from a user to a user
	//
	ReadResponseMessage fetchMessagesFromUserToUser(String fromUser, String toUser);

	//
	// Fetch all the messages in the table
	//
	ReadResponseMessage fetchAllMessages();
}
