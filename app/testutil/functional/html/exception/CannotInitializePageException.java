package testutil.functional.html.exception;

public class CannotInitializePageException extends RuntimeException {

	public CannotInitializePageException(String message) {
		super(message);
	}

	public CannotInitializePageException(String message, Throwable cause) {
		super(message,cause);
	}
}
