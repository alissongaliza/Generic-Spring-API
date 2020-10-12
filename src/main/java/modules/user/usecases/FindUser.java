package modules.user.usecases;

import modules.user.models.User;
import modules.user.ports.repository.IUserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public final class FindUser {

	private final IUserRepository repository;

	public FindUser(final IUserRepository repository) {
		this.repository = repository;
	}

	public Optional<User> findById(final String id) {
		return repository.findById((UUID.fromString(id)));
	}

	public List<User> findAllUsers() {
		return repository.findAll();
	}
}
