package co.com.nxs.person.service;

import co.com.nxs.person.constant.MessageConstant;
import co.com.nxs.person.dto.PersonDto;
import co.com.nxs.person.entities.Person;
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
    private AuditService auditService;
    private PersonMapper personMapper;

    @Autowired
    public PersonService(PersonRepository personRepository,
						 PersonMapper personMapper,
                         AuditService auditService) {
        this.personRepository = personRepository;
		this.personMapper = personMapper;
        this.auditService = auditService;
    }

    public List<PersonDto> getAllPersons() {
        return this.personRepository.findAll()
                .stream().map(personMapper::personEntityToPersonDto
                ).collect(Collectors.toList());
    }

    public PersonDto getPersonById(String personId) {
        return
                this.personMapper.personEntityToPersonDto(
                        this.findById(personId, String.format(MessageConstant.PERSON_NOT_FOUND, personId)));
    }

    public void createPersons(PersonDto personDto) {
		this.personRepository.save(this.personMapper.personDtoToPersonEntity(personDto));
	}

    public void updatePersons(String personId, PersonDto personDto) {
       Person personFromDataBase =
               this.findById(personId, String.format(MessageConstant.FAIL_UPDATE_BY_PERSON_NOT_FOUND, personId));

       personDto.setId(personFromDataBase.getId());
        this.personRepository.save(this.personMapper.personDtoToPersonEntity(personDto));
    }

    public void deletePersonById(String personId) {
        Person personFromDataBase =
                this.findById(personId, String.format(MessageConstant.FAIL_UPDATE_BY_PERSON_NOT_FOUND, personId));
        this.personRepository.delete(personFromDataBase);
    }

    private Person findById(String personId, String message) {
        return this.personRepository.findById(personId).orElseThrow(
                () -> new PersonNotFound(message)
        );
    }
}
