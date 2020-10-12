package modules.user.util.exceptions.domain;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(final String id) {
        super(id);
    }
}
