package int371.project.EventMod.Exceptions;

import java.time.LocalDateTime;

public class ExceptionResponse {

	public static enum ERROR_CODE {
		EVENTS_ID_DOES_NOT_EXIST(1000), EVENTS_NAME_ALREADY_EXIST(1001),
		EVENTS_NAME_DOES_NOT_EXIST(1003);

		ERROR_CODE(int errorValue) {
		}
	}

	private ERROR_CODE errorCode;
	private String message;
	private LocalDateTime dateTime;

	public ExceptionResponse(ERROR_CODE errorCode, String message, LocalDateTime dateTime) {
		this.errorCode = errorCode;
		this.message = message;
		this.dateTime = dateTime;
	}

	public ERROR_CODE getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}