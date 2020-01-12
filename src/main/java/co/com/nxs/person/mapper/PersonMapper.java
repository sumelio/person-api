package co.com.nxs.person.mapper;

import co.com.nxs.person.dto.PersonDto;
import co.com.nxs.person.entities.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDto personEntityToPersonDto(Person person);
    Person personDtoToPersonEntity(PersonDto personDto);
}
