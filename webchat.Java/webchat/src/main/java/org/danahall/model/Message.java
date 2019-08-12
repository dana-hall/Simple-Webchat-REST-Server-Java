package org.danahall.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messages")
public class Message implements MessageDef {

	@Id
	String id;

	String from;
	String to;
	String date;
	String message;
	String v = "0";

	public Message() {

	}

	public Message(String from, String to, String date, String message) {
		this.from = from;
		this.to = to;
		this.date = date;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", from=" + from + ", to=" + to + ", date=" + date + ", message=" + message
				+ ", v=" + v + "]";
	}

}
