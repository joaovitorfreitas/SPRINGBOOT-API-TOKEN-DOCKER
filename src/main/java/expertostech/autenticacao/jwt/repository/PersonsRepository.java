package expertostech.autenticacao.jwt.repository;

import expertostech.autenticacao.jwt.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonsRepository extends JpaRepository<Persons, Integer> {

    public Persons findByCpf(String cpf);

    public Persons findByName(String name);

}
