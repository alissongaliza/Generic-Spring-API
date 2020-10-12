package modules.user.util.validators;

import modules.user.models.User;
import modules.user.util.exceptions.domain.UserValidationException;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class UserValidator {

	public static void validateCreateUser(final User user) {
		if (user == null) throw new UserValidationException("User should not be null");
		if (isBlank(user.getEmail())) throw new UserValidationException("Email should not be null");
		if (isBlank(user.getFirstname())) throw new UserValidationException("First name should not be null");
		if (isBlank(user.getLastname())) throw new UserValidationException("Last name should not be null");
	}

	private UserValidator() {

	}
}
