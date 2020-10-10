package modules.user.adapters.delivery;

import modules.user.controllers.UserController;
import modules.user.models.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SpringUserController {

	private final UserController controller;

	@Autowired
	public SpringUserController(final UserController controller) {
		this.controller = controller;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public UserDTO createUser(@RequestBody final UserDTO userDTO) {
		return controller.createUser(userDTO);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public UserDTO login(@RequestParam("email") final String email, @RequestParam("password") final String password) {
		return controller.login(email, password);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	public UserDTO getUser(@PathVariable("userId") final String userId) {
		return controller.getUser(userId);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserDTO> allUsers() {
		return controller.allUsers();
	}
}

