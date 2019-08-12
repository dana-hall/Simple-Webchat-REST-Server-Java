package org.danahall.dto.responses;

import org.danahall.dto.helpers.Result;
import org.danahall.dto.helpers.Status;
import org.danahall.dto.requests.UpdateRequestMessage;

public class UpdateResponseMessage implements ResponseMessageDef {
	private String id;
	private UpdateRequestMessage request;
	private Result result;

	public UpdateResponseMessage() {
	}

	public UpdateResponseMessage(Status.STATUS status, String id, UpdateRequestMessage req, Object mongoResult) {
		this.id = id;
		this.request = req;
		if (mongoResult == null) {
			this.result = new Result(Status.OPERATION.UPDATE, Status.STATUS.NOT_FOUND, 0, mongoResult);
		} else {
			this.result = new Result(Status.OPERATION.UPDATE, status, 1, mongoResult);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UpdateRequestMessage getRequest() {
		return request;
	}

	public void setRequest(UpdateRequestMessage request) {
		this.request = request;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
}
