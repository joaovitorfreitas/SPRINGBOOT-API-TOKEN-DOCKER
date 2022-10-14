package expertostech.autenticacao.jwt;

import expertostech.autenticacao.jwt.repository.UsuarioRepository;
import expertostech.autenticacao.jwt.services.PersonsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class AutenticacaoJwtApplication {

	static PersonsService p = new PersonsService();

	public static void main(String[] args) {
		SpringApplication.run(AutenticacaoJwtApplication.class, args);

	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

}
