package org.danahall.dto.requests;

public class CreateRequestMessage implements RequestMessageDef {
	private String from;
	private String to;
	private String date;
	private String message;

	public CreateRequestMessage() {
	}

	public CreateRequestMessage(String from, String to, String date, String message) {
		this.from = from;
		this.to = to;
		this.date = date;
		this.message = message;
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

}
