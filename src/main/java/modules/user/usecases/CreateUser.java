package modules.user.usecases;

import modules.user.models.User;
import modules.user.ports.repository.IUserRepository;
import modules.user.ports.usecase.IPasswordEncoder;
import modules.user.util.exceptions.domain.UserAlreadyExistsException;
import modules.user.util.validators.UserValidator;

public final class CreateUser {

	private IUserRepository repository;
	private IPasswordEncoder passwordEncoder;

	protected CreateUser(){}

	public CreateUser(IUserRepository repository,final IPasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}

	public User create(final User user) {
		UserValidator.validateCreateUser(user);
		if (repository.findByEmail(user.getEmail()).isPresent()) {
			throw new UserAlreadyExistsException(user.getEmail());
		}
		User userToSave = User.builder()
			.email(user.getEmail())
			.password(passwordEncoder.encode(user.getEmail() + user.getPassword()))
			.lastName(user.getLastname())
			.firstName(user.getFirstname())
			.build();
		return repository.save(userToSave);
	}
}
