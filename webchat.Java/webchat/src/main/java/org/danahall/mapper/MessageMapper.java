package org.danahall.mapper;

import org.danahall.dto.requests.CreateRequestMessage;
import org.danahall.dto.requests.UpdateRequestMessage;
import org.danahall.model.Message;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class MessageMapper {

	// convert Message to MongoDB DBObject
	public static DBObject toDBObject(Message m) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start().append("from", m.getFrom()).append("to", m.getTo())
				.append("date", m.getDate()).append("message", m.getMessage());
		if (m.getId() != null) {
			builder = builder.append("_id", m.getId());
		}

		return builder.get();
	}

	// convert UpdateRequestMessage to MongoDB DBObject
	public static DBObject toDBObject(UpdateRequestMessage m) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start().append("from", m.getFrom()).append("to", m.getTo())
				.append("date", m.getDate()).append("message", m.getMessage()).append("v", 0);

		return builder.get();
	}

	// convert DBObject Object to Message
	public static Message toMessage(DBObject doc) {

		Message m = new Message();
		m.setFrom((String) doc.get("from"));
		m.setTo((String) doc.get("to"));
		m.setDate((String) doc.get("date").toString());
		m.setMessage((String) doc.get("message"));
		m.setId(doc.get("_id").toString());

		return m;
	}

	// convert CreaeteRequestMessage Object to Message
	public static Message toMessage(CreateRequestMessage message) {

		Message m = new Message();

		m.setFrom(message.getFrom());
		m.setTo(message.getTo());
		m.setDate(message.getDate());
		m.setMessage(message.getMessage());

		return m;
	}
}
