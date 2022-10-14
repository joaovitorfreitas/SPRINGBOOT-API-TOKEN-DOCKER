package expertostech.autenticacao.jwt.mapper;

import expertostech.autenticacao.jwt.dto.UsersDto;
import expertostech.autenticacao.jwt.model.Users;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersMapper {

    private ModelMapper mapper = new ModelMapper();

    public UsersDto fromModeforDto(Users users){
        return mapper.map(users, UsersDto.class);
    }

    public List<UsersDto> fromListModelToListDto(List<Users> users){
        return users.stream().map(users1 -> fromModeforDto(users1)).collect(Collectors.toList());
    }

}
