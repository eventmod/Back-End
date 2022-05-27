package int371.project.EventMod.Exceptions;

public class EventsException extends RuntimeException {
	 private static final long serialVersionUID = 1L;
	ExceptionResponse.ERROR_CODE errorCode;

	public EventsException(ExceptionResponse.ERROR_CODE errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ExceptionResponse.ERROR_CODE getErrorCode() {
		return this.errorCode;
	}
}