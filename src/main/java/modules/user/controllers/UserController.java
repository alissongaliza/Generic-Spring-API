package modules.user.controllers;

import modules.user.models.User;
import modules.user.models.UserDTO;
import modules.user.usecases.CreateUser;
import modules.user.usecases.FindUser;
import modules.user.usecases.LoginUser;

import java.util.List;
import java.util.stream.Collectors;

public class UserController {

	private final CreateUser createUser;
	private final FindUser findUser;
	private final LoginUser loginUser;

	public UserController(final CreateUser createUser, final FindUser findUser, final LoginUser loginUser) {
		this.createUser = createUser;
		this.findUser = findUser;
		this.loginUser = loginUser;
	}

	public UserDTO createUser(final UserDTO userDTO) {
		User user = userDTO.toUser();
		return UserDTO.toUserDTO(createUser.create(user));
	}

	public UserDTO login(final String email, final String password) {
		return UserDTO.toUserDTO(loginUser.login(email, password));
	}

	public UserDTO getUser(final String userId) {
		return UserDTO.toUserDTO(findUser.findById(userId).orElseThrow(() -> new UserNotFoundException(userId)));
	}

	public List<UserDTO> allUsers() {
		return findUser.findAllUsers()
			.stream()
			.map(UserDTO::toUserDTO)
			.collect(Collectors.toList());
	}
}
