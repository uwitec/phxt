package cn.com.framework.beans;
public class Result<E> {
	private boolean isSuccess = true;
	private String message;
	private E result;

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public E getResult() {
		return result;
	}

	public void setResult(E result) {
		this.result = result;
	}
}
