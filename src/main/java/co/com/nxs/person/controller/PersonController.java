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

package co.com.nxs.person.controller;

import co.com.nxs.person.constant.MessageConstant;
import co.com.nxs.person.constant.RestConstant;
import co.com.nxs.person.dto.PersonDto;
import co.com.nxs.person.dto.ResponseDto;
import co.com.nxs.person.enums.ResponseCode;
import co.com.nxs.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for Person rest api.
 *
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="sumel124@gmail.com">Freddy Lemus</a>
 *
 */
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
                .responseCode(ResponseCode.SUCCESS)
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
                .responseCode(ResponseCode.SUCCESS)
                .message(MessageConstant.OK)
                .build();
    }

    /**
     * Creates a person
     *
     * @param personDto object
     * @return Message result
     */
    @PostMapping
    public ResponseDto<PersonDto> createPerson(@RequestBody @Valid PersonDto personDto) {
        this.personService.createPersons(personDto);
        return ResponseDto.
                <PersonDto>builder()
                .code(HttpStatus.OK.value())
                .responseCode(ResponseCode.SUCCESS)
                .message(MessageConstant.SUCCESSFUL_CREATED)
                .build();
    }

    /**
     * Update a person
     *
     * @param personId ID of person
     * @param personDto object
     * @return Message result
     */
    @PutMapping(RestConstant.UPDATE_PERSON_BY_ID)
    public ResponseDto<PersonDto> createPerson(@PathVariable(value = "personId") String personId, @RequestBody @Valid PersonDto personDto) {
        this.personService.createPersons(personDto);
        return ResponseDto.
                <PersonDto>builder()
                .code(HttpStatus.OK.value())
                .responseCode(ResponseCode.SUCCESS)
                .message(MessageConstant.SUCCESSFUL_UPDATED)
                .build();
    }

    /**
     * Gets a person by id
     *
     * @param personId ID of person
     * @return Message response with person object
     */
    @DeleteMapping(RestConstant.DELETE_PERSON_BY_ID)
    public ResponseDto<PersonDto> deletePersonById(@PathVariable(value = "personId") String personId) {
        this.personService.deletePersonById(personId);
        return ResponseDto.
                <PersonDto>builder()
                .code(HttpStatus.OK.value())
                .responseCode(ResponseCode.SUCCESS)
                .message(MessageConstant.SUCCESSFUL_DELETE)
                .build();
    }
}
