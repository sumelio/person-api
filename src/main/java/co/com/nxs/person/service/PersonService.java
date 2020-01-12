package co.com.nxs.person.service;

import co.com.nxs.person.controller.MessageConstant;
import co.com.nxs.person.dto.PersonDto;
import co.com.nxs.person.handler.customeException.PersonNotFound;
import co.com.nxs.person.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.nxs.person.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private PersonMapper personMapper;

    @Autowired
    public PersonService(PersonRepository personRepository,
						 PersonMapper personMapper) {
        this.personRepository = personRepository;
		this.personMapper = personMapper;
    }

    public List<PersonDto> getAllPersons() {
        return this.personRepository.findAll()
                .stream().map(personMapper::personEntityToPersonDto
                ).collect(Collectors.toList());
    }

    public PersonDto getPersonById(String personId) {
        return
                this.personMapper.personEntityToPersonDto(
                        this.personRepository.findById(personId).orElseThrow(
                                () -> new PersonNotFound(String.format(MessageConstant.PERSON_NOT_FOUND, personId))
                        ));
    }

	public void createPersons(PersonDto personDto) {
		this.personRepository.save(this.personMapper.personDtoToPersonEntity(personDto));
	}
}
