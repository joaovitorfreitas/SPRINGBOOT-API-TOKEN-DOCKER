package expertostech.autenticacao.jwt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonsDto {

    private Integer IDPERSONS;

    private String cpf;

    private String name;

    private String street;

    private Integer numberhome;

    private String district;

    private String complement;

    private String county;

    private String uf;

    private String rg;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime birthday;
}
