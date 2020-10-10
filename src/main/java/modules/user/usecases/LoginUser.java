package modules.user.usecases;

import modules.user.models.User;
import modules.user.ports.repository.IUserRepository;
import modules.user.ports.usecase.IPasswordEncoder;
import modules.user.util.exceptions.NotAllowedException;

public final class LoginUser {

	private final IUserRepository userRepository;
	private final IPasswordEncoder passwordEncoder;

	public LoginUser(final IUserRepository userRepository, final IPasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public User login(final String email, final String password) {
		User user = userRepository.findByEmail(email).orElseThrow(() -> new NotAllowedException("Not allowed"));
		String hashedPassword = passwordEncoder.encode(email + password);
		if (!user.getPassword().equals(hashedPassword)) throw new NotAllowedException("Not allowed");
		return user;
	}
}
