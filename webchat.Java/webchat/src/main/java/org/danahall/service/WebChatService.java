package org.danahall.service;

import org.danahall.dao.MessageDAO;
import org.danahall.dto.requests.CreateRequestMessage;
import org.danahall.dto.requests.DeleteRequestMessage;
import org.danahall.dto.requests.UpdateRequestMessage;
import org.danahall.dto.responses.CreateResponseMessage;
import org.danahall.dto.responses.DeleteResponseMessage;
import org.danahall.dto.responses.ReadResponseMessage;
import org.danahall.dto.responses.UpdateResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebChatService implements WebChatServiceDef {

	@Autowired
	private MessageDAO messageDao;

	//
	// Create a message
	//
	public CreateResponseMessage createMessage(CreateRequestMessage req) {

		CreateResponseMessage response = messageDao.createMessage(req);

		return response;
	}

	//
	// Delete all messages
	//
	public DeleteResponseMessage deleteMessages(DeleteRequestMessage req) {

		DeleteResponseMessage response = messageDao.deleteMessages(req);

		return response;
	}

	//
	// Update a message
	//
	public UpdateResponseMessage updateMessage(String id, UpdateRequestMessage req) {

		UpdateResponseMessage response = messageDao.updateMessage(id, req);

		return response;
	}

	//
	// Retrieve all messages belonging to a user
	//
	public ReadResponseMessage fetchUserMessages(String user) {

		ReadResponseMessage response = messageDao.fetchUserMessages(user);

		return response;
	}

	//
	// Retrieve all messages from a user
	//
	public ReadResponseMessage fetchMessagesFromUser(String user) {

		ReadResponseMessage messages = messageDao.fetchMessagesFromUser(user);

		return messages;
	}

	//
	// Fetch all messages from a user to a user
	//
	public ReadResponseMessage fetchMessagesFromUserToUser(String fromUser, String toUser) {

		ReadResponseMessage messages = messageDao.fetchMessagesFromUserToUser(fromUser, toUser);

		return messages;
	}

	//
	// Fetch all the messages in the table
	//
	public ReadResponseMessage fetchAllMessages() {

		ReadResponseMessage response = messageDao.fetchAllMessages();

		return response;
	}
}
