package expertostech.autenticacao.jwt.repository;

import expertostech.autenticacao.jwt.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Users, Integer> {
    public Optional<Users> findByEmail(String login);
}
