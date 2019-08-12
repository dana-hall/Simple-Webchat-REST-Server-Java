package org.danahall.dto.responses;

import org.danahall.dto.helpers.Result;
import org.danahall.dto.helpers.Status;
import org.danahall.dto.requests.CreateRequestMessage;
import org.danahall.model.Message;

public class CreateResponseMessage implements ResponseMessageDef {
	private Message message;
	private CreateRequestMessage request;
	private Result result;

	public CreateResponseMessage() {
	}

	public CreateResponseMessage(Status.STATUS status, CreateRequestMessage req, Message message, Object mongoResult) {
		this.message = message;
		this.request = req;
		this.result = new Result(Status.OPERATION.CREATE, status, 1, mongoResult);
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public CreateRequestMessage getRequest() {
		return request;
	}

	public void setRequest(CreateRequestMessage request) {
		this.request = request;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}