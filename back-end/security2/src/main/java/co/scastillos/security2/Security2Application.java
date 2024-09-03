package co.scastillos.security2;

import co.scastillos.security2.entity.Usuario;
import co.scastillos.security2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import static co.scastillos.security2.entity.Rol.*;

@SpringBootApplication
public class Security2Application implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Security2Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Usuario admin = Usuario.builder()
				.username("admin")
				.password(passwordEncoder.encode("1234"))
				.age(25)
				.roles(ADMINISTRADOR)
				.email("scastillos3@ucentral.edu.co")
				.build();
		userRepository.save(admin);
	}
}
