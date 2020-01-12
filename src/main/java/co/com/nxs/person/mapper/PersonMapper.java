/*
 *
 *  *   Copyright 2020, Nexos Software S.A.S
 *  *   https://nxs.com.co/
 *  *
 *  *   All rights reserved
 *  *   Date: 12/02/2020
 *
 *
 */

package co.com.nxs.person.mapper;

import co.com.nxs.person.dto.PersonDto;
import co.com.nxs.person.entities.Person;
import org.mapstruct.Mapper;

/**
 * Person mapper
 *
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="sumel124@gmail.com">Freddy Lemus</a>
 *
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDto personEntityToPersonDto(Person person);
    Person personDtoToPersonEntity(PersonDto personDto);
}
