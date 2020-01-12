package co.com.nxs.person.service;

import co.com.nxs.person.controller.MessageConstant;
import co.com.nxs.person.dto.PersonDto;
import co.com.nxs.person.handler.customeException.PersonNotFound;
import co.com.nxs.person.mapper.PersonMapper;
import co.com.nxs.person.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.nxs.person.repository.PersonRepository;

import java.time.LocalDateTime;
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
        auditService.logInput("getAllPersons", "Empty", LocalDateTime.now(), "INPUT");
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
