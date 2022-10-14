package expertostech.autenticacao.jwt.controller;

import expertostech.autenticacao.jwt.dto.UsersDto;
import expertostech.autenticacao.jwt.model.Users;
import expertostech.autenticacao.jwt.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    private UsersController(UsersService usersService){
        this.usersService = usersService;
    }


    @PostMapping("/criarnovo")
    public UsersDto CriarNovo(@RequestBody Users users){

        return this.usersService.Save(users);
    }

    // @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/ListarNovo")
    public List<UsersDto> Listar(){
        return this.usersService.findAll();
    }

    @DeleteMapping("/RemoverUsuario/{id}")
    public void DeletarUsuario(@PathVariable Integer id){

        usersService.Remove(id);
    }

    @GetMapping("/PegarUsuario/{id}")
    public UsersDto PegarUsuario(@PathVariable Integer id){

        return this.usersService.FindById(id);
    }

}
