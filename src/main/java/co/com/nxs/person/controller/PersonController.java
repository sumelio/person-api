package co.com.nxs.person.controller;

import co.com.nxs.person.constant.RestConstant;
import co.com.nxs.person.dto.PersonDto;
import co.com.nxs.person.dto.ResponseDto;
import co.com.nxs.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
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
                .build();
    }
    /**
     * Gets a person by id
     *
     * @param personId ID of person
     * @return Message response with person object
     */
    @GetMapping(RestConstant.GET_PERSON_BY_ID)
    public ResponseDto<PersonDto> getPersonById(@PathParam(value = "personId") String personId) {
        return ResponseDto.
                <PersonDto>builder()
                .data(this.personService.getPersonById(personId))
                .build();
    }
}
