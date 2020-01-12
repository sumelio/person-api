package co.com.nxs.person.controller;

import co.com.nxs.person.constant.RestConstant;
import co.com.nxs.person.dto.PersonDto;
import co.com.nxs.person.dto.ResponseDto;
import co.com.nxs.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = RestConstant.END_POINT, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Gets all persons
     *
     * @return List of persons
     */
    @GetMapping()
    public ResponseDto<List<PersonDto>> getAllPersons() {
        return ResponseDto.
                <List<PersonDto>>builder()
                .data(this.personService.getAllPersons())
                .code(HttpStatus.OK.value())
                .message(MessageConstant.OK)
                .build();
    }
    /**
     * Gets a person by id
     *
     * @param personId ID of person
     * @return Message response with person object
     */
    @GetMapping(RestConstant.GET_PERSON_BY_ID)
    public ResponseDto<PersonDto> getPersonById(@PathVariable(value = "personId") String personId) {
        return ResponseDto.
                <PersonDto>builder()
                .data(this.personService.getPersonById(personId))
                .code(HttpStatus.OK.value())
                .message(MessageConstant.OK)
                .build();
    }

    /**
     * Creates person
     * @param personDto object
     * @return Message result
     */
    @PostMapping
    public ResponseDto<PersonDto> createPerson(@RequestBody @Valid PersonDto personDto) {
        this.personService.createPersons(personDto);
        return ResponseDto.
                <PersonDto>builder()
                .code(HttpStatus.OK.value())
                .message(MessageConstant.SUCCESSFUL_CREATED)
                .build();
    }
}
