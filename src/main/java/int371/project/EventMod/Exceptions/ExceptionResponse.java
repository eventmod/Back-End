package int371.project.EventMod.Exceptions;

import java.time.LocalDateTime;

public class ExceptionResponse {

	public static enum ERROR_CODE {
		EVENTS_ID_DOES_NOT_EXIST(1000), EVENTS_NAME_ALREADY_EXIST(1001),
		EVENTS_NAME_DOES_NOT_EXIST(1002),EVENTS_ID_NO_CONTACT(1004),
		
		ACCOUNT_ID_DOES_NOT_EXIST(2000), ACCOUNT_NAME_ALREADY_EXIST(2001),
		ACCOUNT_NAME_DOES_NOT_EXIST(2002),
		
		CONTACT_ID_DOES_NOT_EXIST(3000), CONTACT_NAME_ALREADY_EXIST(3001),
		CONTACT_NAME_DOES_NOT_EXIST(3002),

		ADMIN_ID_DOES_NOT_EXIST(4000), ADMIN_NAME_ALREADY_EXIST(4001),
		ADMIN_NAME_DOES_NOT_EXIST(4002),
		
		CREATOR_ID_DOES_NOT_EXIST(4000), CREATOR_NAME_ALREADY_EXIST(4001),
		CREATOR_NAME_DOES_NOT_EXIST(4002),

		LINEACCOUNT_ID_DOES_NOT_EXIST(5000), LINEACCOUNT_USERID_ALREADY_EXIST(5001),
		LINEACCOUNT_USERID_DOES_NOT_EXIST(5002),

		EVENTJOINED_ID_DOES_NOT_EXIST(6000),
		;

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