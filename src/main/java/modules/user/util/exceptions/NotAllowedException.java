package modules.user.util.exceptions;

public class NotAllowedException extends RuntimeException {
	public NotAllowedException(final String message) {
		super(message);
	}
}
