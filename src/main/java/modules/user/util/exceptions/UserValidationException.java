package modules.user.util.exceptions;

public class UserValidationException extends RuntimeException {
	public UserValidationException(final String message) {
		super(message);
	}
}
