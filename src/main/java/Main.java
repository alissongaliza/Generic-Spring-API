import modules.user.adapters.delivery.SpringUserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "modules")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
