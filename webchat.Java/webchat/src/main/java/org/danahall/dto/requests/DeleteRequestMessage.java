package org.danahall.dto.requests;

public class DeleteRequestMessage implements RequestMessageDef {

	private String from;
	private String to;

	public DeleteRequestMessage() {
	}

	public DeleteRequestMessage(String from, String to) {
		this.from = from;
		this.to = to;
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

}
