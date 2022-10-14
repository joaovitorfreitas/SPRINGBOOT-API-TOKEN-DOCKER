package expertostech.autenticacao.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IDUSERS;

    @Column(unique = true)
    private String email;

    private String password;

    private Boolean administrator;

    @OneToOne()
    @JoinColumn(name = "IDPERSONS")
    private Persons Persons;
}
