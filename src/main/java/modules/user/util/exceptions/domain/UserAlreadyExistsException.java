package modules.user.util.exceptions.domain;

public class UserAlreadyExistsException extends RuntimeException {
	public UserAlreadyExistsException(final String email) {
		super(email);
	}
}
