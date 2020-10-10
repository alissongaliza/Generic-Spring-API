package modules.user.usecases;

import modules.user.models.User;
import modules.user.ports.repository.IUserRepository;
import modules.user.ports.usecase.IIdGenerator;
import modules.user.ports.usecase.IPasswordEncoder;
import modules.user.util.exceptions.UserAlreadyExistsException;
import modules.user.util.validators.UserValidator;

public final class CreateUser {

	private final IUserRepository repository;
	private final IPasswordEncoder passwordEncoder;
	private final IIdGenerator idGenerator;

	public CreateUser(final IUserRepository repository, final IPasswordEncoder passwordEncoder, final IIdGenerator idGenerator) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.idGenerator = idGenerator;
	}

	public User create(final User user) {
		UserValidator.validateCreateUser(user);
		if (repository.findByEmail(user.getEmail()).isPresent()) {
			throw new UserAlreadyExistsException(user.getEmail());
		}
		User userToSave = User.builder()
			.id(idGenerator.generate())
			.email(user.getEmail())
			.password(passwordEncoder.encode(user.getEmail() + user.getPassword()))
			.lastName(user.getLastName())
			.firstName(user.getFirstName())
			.build();
		return repository.create(userToSave);
	}
}
