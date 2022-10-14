package expertostech.autenticacao.jwt;
import expertostech.autenticacao.jwt.services.PersonsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@SpringBootTest
@ContextConfiguration
public class PersonsServiceTest {

    @Autowired
    PersonsService personsService;

    LocalDateTime dataAniver = LocalDateTime.parse("2003-10-09T11:15:30", DateTimeFormatter.ISO_DATE_TIME);


    @Test
    public void MaiorIdade(){

        Integer age = personsService.CalculetedAge(dataAniver);


        Assertions.assertTrue(age > 18);
    }

    @Test
    public void MenorIdade(){
        Integer age = personsService.CalculetedAge(dataAniver);

        Assertions.assertTrue(age < 18);
    }

    @Test
    public void IgualIdade(){

        Integer age = personsService.CalculetedAge(dataAniver);

        Assertions.assertEquals(18, age);
    }
}
