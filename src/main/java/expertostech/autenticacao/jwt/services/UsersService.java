package expertostech.autenticacao.jwt.services;

import expertostech.autenticacao.jwt.dto.UsersDto;
import expertostech.autenticacao.jwt.mapper.UsersMapper;
import expertostech.autenticacao.jwt.model.Users;
import expertostech.autenticacao.jwt.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersService {

    UsersMapper usersMapper = new UsersMapper();

    @Autowired
    UsuarioRepository usersRepository;


    public List<UsersDto> findAll(){
        List<Users> users = usersRepository.findAll();

        return usersMapper.fromListModelToListDto(users);
    }

    public UsersDto FindById(Integer id){
        Users users = usersRepository.findById(id).get();

        return usersMapper.fromModeforDto(users);
    }

    @Transactional
    public UsersDto Save(Users users){
        users.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));

        return  usersMapper.fromModeforDto(usersRepository.save(users));
    }

    @Transactional
    public void Remove (Integer id){

        usersRepository.deleteById(id);
    }

}
