package expertostech.autenticacao.jwt.services;

import expertostech.autenticacao.jwt.dto.PersonsDto;
import expertostech.autenticacao.jwt.mapper.PersonsMapper;
import expertostech.autenticacao.jwt.model.Persons;
import expertostech.autenticacao.jwt.repository.PersonsRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

@Service
public class PersonsService {

    PersonsMapper personsMapper = new PersonsMapper();

    @Autowired
    PersonsRepository personsRepository;



    public List<PersonsDto> findAll(){
        List<Persons> persons = personsRepository.findAll();

        return personsMapper.fromListModelToListDto(persons);
    }

    public PersonsDto FindById(Integer id){
        Persons persons = personsRepository.findById(id).get();

        return personsMapper.fromModeforDto(persons);
    }

    public PersonsDto FindbyCpf(String cpf){
        Persons persons = personsRepository.findByCpf(cpf);

        return personsMapper.fromModeforDto(persons);
    }

    public PersonsDto FindbyName(String name) {
        Persons persons = personsRepository.findByName(name);

        return personsMapper.fromModeforDto(persons);
    }

    @Transactional
    public PersonsDto Save(Persons persons){

        return  personsMapper.fromModeforDto(personsRepository.save(persons));
    }

    public Integer CalculetedAge(LocalDateTime date  ) {

        Calendar DataAniversario = Calendar.getInstance();
        DataAniversario.set(Calendar.DATE, date.getDayOfMonth());
        DataAniversario.set(Calendar.MONTH, date.getMonthValue());

        Calendar DataAtual = Calendar.getInstance();
        DataAtual.set(Calendar.DATE, LocalDateTime.now().getDayOfMonth());
        DataAtual.set(Calendar.MONTH, LocalDateTime.now().getMonthValue());

        Integer age = LocalDateTime.now().getYear() - date.getYear();


        if(age != 18){
            return age;
        }

        if(DataAniversario.before(DataAtual)){
            return age - 1;
        }

        return age;
    }

    @Transactional
    public void Remove(Integer id)
    {

        personsRepository.deleteById(id);
    }

    @Transactional
    public void RemoveAll(){
        personsRepository.deleteAll();
    }

    @Transactional
    public PersonsDto Update(Integer Id, Persons persons){

        Persons pers = personsRepository.findById(Id).get();

        pers.setComplement(persons.getComplement());
        pers.setCounty(persons.getCounty());
        pers.setCpf(persons.getCpf());
        pers.setRg(persons.getRg());
        pers.setDistrict(persons.getDistrict());
        pers.setUf(persons.getUf());
        pers.setName(persons.getName());
        pers.setStreet(persons.getStreet());
        pers.setNumberhome(persons.getNumberhome());

        return personsMapper.fromModeforDto(pers);
    }
}
