package org.danahall.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.danahall.dto.helpers.Status;
import org.danahall.dto.requests.CreateRequestMessage;
import org.danahall.dto.requests.DeleteRequestMessage;
import org.danahall.dto.requests.UpdateRequestMessage;
import org.danahall.dto.responses.CreateResponseMessage;
import org.danahall.dto.responses.DeleteResponseMessage;
import org.danahall.dto.responses.ReadResponseMessage;
import org.danahall.dto.responses.UpdateResponseMessage;
import org.danahall.factory.MongoFactory;
import org.danahall.mapper.MessageMapper;
import org.danahall.model.Message;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoWriteException;
import com.mongodb.WriteResult;

public class MessageDAO implements MessageDAODef {

	private DBCollection col;

	public MessageDAO() {
		this.col = MongoFactory.getCollection();
	}

	//
	// Create a message
	//
	public CreateResponseMessage createMessage(CreateRequestMessage msg) {

		CreateResponseMessage response;
		Message message = MessageMapper.toMessage(msg);
		DBObject doc = MessageMapper.toDBObject(message);

		// Save a new message to the mongo collection.
		try {
			col.insert(doc);
			message.setId(doc.get("_id").toString());
			response = new CreateResponseMessage(Status.STATUS.SUCCESS, msg, message, null);
		} catch (MongoWriteException err) {
			response = new CreateResponseMessage(Status.STATUS.ERROR, msg, message, err);
		}

		return response;
	}

	//
	// Delete all messages
	//
	public DeleteResponseMessage deleteMessages(DeleteRequestMessage req) {

		WriteResult result;
		DeleteResponseMessage response;

		// Setup 'or' query
		BasicDBObject query = new BasicDBObject();
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("from", req.getFrom()));
		obj.add(new BasicDBObject("to", req.getTo()));
		query.put("$and", obj);

		try {
			result = col.remove(query);
			response = new DeleteResponseMessage(Status.STATUS.SUCCESS, req, result);
		} catch (MongoWriteException err) {
			response = new DeleteResponseMessage(Status.STATUS.ERROR, req, err);
		}

		return response;
	}

	//
	// Update a message
	//
	public UpdateResponseMessage updateMessage(String id, UpdateRequestMessage req) {
		UpdateResponseMessage response;
		ObjectId oid = new ObjectId(id);

		try {
			BasicDBObject filter = new BasicDBObject();
			filter.put("_id", oid);

			DBObject update = MessageMapper.toDBObject(req);
			DBObject result = col.findAndModify(filter, update);
			response = new UpdateResponseMessage(Status.STATUS.SUCCESS, id, req, result);
		} catch (MongoWriteException err) {
			response = new UpdateResponseMessage(Status.STATUS.ERROR, id, req, err);
		}

		return response;
	}

	//
	// Retrieve all messages belonging to a user
	//
	public ReadResponseMessage fetchUserMessages(String user) {
		List<Message> messages = new ArrayList<Message>();
		ReadResponseMessage response;

		// Setup 'or' query
		BasicDBObject query = new BasicDBObject();
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("from", user));
		obj.add(new BasicDBObject("to", user));
		query.put("$or", obj);

		try {
			DBCursor cursor = col.find(query);

			while (cursor.hasNext()) {
				DBObject doc = cursor.next();
				Message m = MessageMapper.toMessage(doc);
				messages.add(m);
			}
			response = new ReadResponseMessage(Status.STATUS.SUCCESS, messages, null);
		} catch (MongoWriteException err) {
			response = new ReadResponseMessage(Status.STATUS.ERROR, messages, err);
		}

		return response;
	}

	//
	// Retrieve all messages from a user
	//
	public ReadResponseMessage fetchMessagesFromUser(String user) {
		List<Message> messages = new ArrayList<Message>();
		ReadResponseMessage response;

		BasicDBObject query = new BasicDBObject();
		query.put("from", user);

		try {
			DBCursor cursor = col.find(query);

			while (cursor.hasNext()) {
				DBObject doc = cursor.next();
				Message m = MessageMapper.toMessage(doc);
				messages.add(m);
			}
			response = new ReadResponseMessage(Status.STATUS.SUCCESS, messages, null);
		} catch (MongoWriteException err) {
			response = new ReadResponseMessage(Status.STATUS.SUCCESS, messages, err);
		}

		return response;
	}

	//
	// Fetch all messages from a user to a user
	//
	public ReadResponseMessage fetchMessagesFromUserToUser(String fromUser, String toUser) {
		List<Message> messages = new ArrayList<Message>();
		ReadResponseMessage response;

		// Setup 'or' query
		BasicDBObject query = new BasicDBObject();
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("from", fromUser));
		obj.add(new BasicDBObject("to", toUser));
		query.put("$and", obj);

		try {
			DBCursor cursor = col.find(query);

			while (cursor.hasNext()) {
				DBObject doc = cursor.next();
				Message m = MessageMapper.toMessage(doc);
				messages.add(m);
			}
			response = new ReadResponseMessage(Status.STATUS.SUCCESS, messages, null);
		} catch (MongoWriteException err) {
			response = new ReadResponseMessage(Status.STATUS.SUCCESS, messages, err);
		}

		return response;
	}

	//
	// Fetch all the messages in the table
	//
	public ReadResponseMessage fetchAllMessages() {
		List<Message> messages = new ArrayList<Message>();
		ReadResponseMessage response;

		try {
			DBCursor cursor = col.find();
			while (cursor.hasNext()) {
				DBObject doc = cursor.next();
				Message m = MessageMapper.toMessage(doc);
				messages.add(m);
			}
			response = new ReadResponseMessage(Status.STATUS.SUCCESS, messages, null);
		} catch (MongoWriteException err) {
			response = new ReadResponseMessage(Status.STATUS.SUCCESS, messages, err);
		}

		return response;
	}

}
