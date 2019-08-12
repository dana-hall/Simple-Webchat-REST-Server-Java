package org.danahall.dto.responses;

import java.util.List;

import org.danahall.dto.helpers.Result;
import org.danahall.dto.helpers.Status;
import org.danahall.model.Message;

public class ReadResponseMessage implements ResponseMessageDef {
	private List<Message> messages;
	private Result result;

	public ReadResponseMessage() {
	}

	public ReadResponseMessage(Status.STATUS status, List<Message> messages, Object mongoResult) {
		this.result = new Result(Status.OPERATION.READ, status, messages.size(), mongoResult);
		this.messages = messages;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}