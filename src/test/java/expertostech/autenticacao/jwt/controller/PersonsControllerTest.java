package expertostech.autenticacao.jwt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import expertostech.autenticacao.jwt.dto.PersonsDto;
import expertostech.autenticacao.jwt.services.PersonsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
public class PersonsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    PersonsService personsService;

    @Test
    @Sql(statements = "INSERT INTO Persons (NAME) VALUES('joaoo')")
    @Sql(statements = "INSERT INTO Persons (NAME) VALUES('juja')")
    public void listarPessoas() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Persons")

                )
                .andExpect(MockMvcResultMatchers.status().isOk()).
                andDo((MockMvcResultHandlers.print()));
    }

    @Test
    public void salvarPessoas() throws Exception {

        PersonsDto persons = PersonsDto.builder()
                .rg("22.918.060-7")
                .cpf("628.623.480-3")
                .uf("DF")
                .name("Joao")
                .numberhome(223)
                .street("Área Especial SEDB Carmelo Nossa Senhora do Carmo")
                .county("São paulo")
                .complement("casa 1")
                .district("Brasília")
                .IDPERSONS(1)
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/Persons/CriarPerso")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(persons))
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    @Sql(statements = "INSERT INTO Persons (CPF) VALUES('628.623.480-3')")
    public void BuscarCpf() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Persons/BuscarPessoaCpf/628.623.480-3")
                )   .andExpect(MockMvcResultMatchers.status().isOk()).
                andDo((MockMvcResultHandlers.print()));
    }


    @Test
    @Sql(statements = "INSERT INTO Persons (NAME) VALUES('juja')")
    public void removerPessoas() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders.delete("/Persons/DeletarPerso/1")
        )   .andExpect(MockMvcResultMatchers.status().isOk()).
                andDo((MockMvcResultHandlers.print()));
    }


}
