package modules.user.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import modules.user.adapters.repository.InMemoryIUserRepository;
import modules.user.adapters.usecase.Sha256IPasswordEncoder;
import modules.user.adapters.usecase.UuidGeneratorI;
import modules.user.controllers.UserController;
import modules.user.ports.repository.IUserRepository;
import modules.user.ports.usecase.IPasswordEncoder;
import modules.user.usecases.CreateUser;
import modules.user.usecases.FindUser;
import modules.user.usecases.LoginUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

	private final IUserRepository userRepository = new InMemoryIUserRepository();
	private final IPasswordEncoder IPasswordEncoder = new Sha256IPasswordEncoder();

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return objectMapper;
	}
		@Bean
	public CreateUser createUser() {
		return new CreateUser(userRepository, IPasswordEncoder, new UuidGeneratorI());
	}
	@Bean
	public FindUser findUser() {
		return new FindUser(userRepository);
	}
	@Bean
	public LoginUser loginUser() {
		return new LoginUser(userRepository, IPasswordEncoder);
	}

	@Bean
	public UserController userController() {
		return new UserController(createUser(), findUser(), loginUser());
	}

}
