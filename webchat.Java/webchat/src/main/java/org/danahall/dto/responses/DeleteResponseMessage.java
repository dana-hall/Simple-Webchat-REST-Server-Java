package org.danahall.dto.responses;

import org.danahall.dto.helpers.Result;
import org.danahall.dto.helpers.Status;
import org.danahall.dto.requests.DeleteRequestMessage;

public class DeleteResponseMessage implements ResponseMessageDef {
	private DeleteRequestMessage request;
	private Result result;

	public DeleteResponseMessage(Status.STATUS status, DeleteRequestMessage request, Object mongoResult) {
		this.request = request;
		this.result = new Result(Status.OPERATION.DELETE, status, -1, mongoResult);
	}

	public DeleteRequestMessage getRequest() {
		return request;
	}

	public void setRequest(DeleteRequestMessage request) {
		this.request = request;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
