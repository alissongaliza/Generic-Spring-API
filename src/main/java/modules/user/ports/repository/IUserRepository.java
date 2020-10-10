package modules.user.ports.repository;

import modules.user.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    User create(User user);

    Optional<User> findById(String id);

    Optional<User> findByEmail(String email);

    List<User> findAllUsers();
}