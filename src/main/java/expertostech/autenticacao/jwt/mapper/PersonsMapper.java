package expertostech.autenticacao.jwt.mapper;

import expertostech.autenticacao.jwt.dto.PersonsDto;
import expertostech.autenticacao.jwt.model.Persons;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonsMapper {

    private ModelMapper mapper = new ModelMapper();

    public PersonsDto fromModeforDto(Persons persons){
        return mapper.map(persons, PersonsDto.class);
    }

    public List<PersonsDto> fromListModelToListDto(List<Persons> persons){
        return persons.stream().map(persons1 -> fromModeforDto(persons1)).collect(Collectors.toList());
    }
}
