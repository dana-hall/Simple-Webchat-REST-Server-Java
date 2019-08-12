package org.danahall.dto.helpers;

public class Result {
	private String operation;
	private String status;
	private String message;
	private int count;
	private Object mongoResult;

	public Result() {
	}

	public Result(Status.OPERATION operation, Status.STATUS status, int count, Object mongoResult) {
		this.count = count;
		this.mongoResult = mongoResult;
		switch (status) {
		case SUCCESS: {
			this.status = "Success";
			this.message = "Operation Successful";
			break;
		}
		case NOT_FOUND: {
			this.status = "Success";
			this.message = "No results or not found";
			break;
		}
		case ERROR: {
			this.status = "Error";
			this.message = "Operation Failure";
			break;
		}
		default:
			break;
		}

		switch (operation) {
		case CREATE: {
			this.operation = "Create";
			break;
		}
		case READ: {
			this.operation = "Read";
			break;
		}
		case UPDATE: {
			this.operation = "Update";
			break;
		}
		case DELETE: {
			this.operation = "Delete";
			break;
		}
		default:
			break;
		}

	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Object getMongoResult() {
		return mongoResult;
	}

	public void setMongoResult(Object mongoResult) {
		this.mongoResult = mongoResult;
	}

}
