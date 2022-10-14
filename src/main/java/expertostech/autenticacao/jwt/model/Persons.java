package expertostech.autenticacao.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Persons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IDPERSONS;

    @Column(unique = true)
    private String cpf;

    private String name;

    private String street;

    private Integer numberhome;

    private String district;

    private String complement;

    private String county;

    private String uf;

    private String rg;

    private LocalDateTime birthday;

    @OneToOne(mappedBy = "Persons")
    private Users users;
}
