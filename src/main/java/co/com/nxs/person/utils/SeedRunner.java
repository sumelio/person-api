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

package co.com.nxs.person.utils;

import co.com.nxs.person.entities.Person;
import co.com.nxs.person.entities.Relative;
import co.com.nxs.person.enums.RelativeType;
import co.com.nxs.person.mapper.PersonMapper;
import co.com.nxs.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Seed Runner for init data
 *
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="sumel124@gmail.com">Freddy Lemus</a>
 *
 */
@Component
public class SeedRunner implements ApplicationRunner {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonMapper personMapper;

    public void seed(ContextRefreshedEvent event) {
        seedPersonDocument();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        seedPersonDocument();
    }

    private void seedPersonDocument() {

        Person person =
                Person.builder()
                        .birthDate(LocalDate.now())
                        .id("1000001")
                        .name("Bart")
                        .lastName("Simpson")
                        .relatives(new ArrayList<>())
                        .build();

        person.getRelatives().add(
                Relative.builder()
                        .relativeType(RelativeType.AUNT)
                        .person(getPersonFromData("100004", "Selma", "Bouvier"))
                        .build()
        );

        person.getRelatives().add(
                Relative.builder()
                        .relativeType(RelativeType.SISTER)
                        .person(getPersonFromData("100004", "Maggie", "Simpson"))
                        .build());

        person.getRelatives().add(
                Relative.builder()
                        .relativeType(RelativeType.MOTHER)
                        .person(getPersonFromData("100004", "Marge", "Simpson"))
                        .build());

        person.getRelatives().add(
                Relative.builder()
                        .relativeType(RelativeType.FATHER)
                        .person(getPersonFromData("100004", "Homero", "Simpson"))
                        .build());

        person.getRelatives().add(
                Relative.builder()
                        .relativeType(RelativeType.GRANDFATHER)
                        .person(getPersonFromData("100004", "Abraham", "Simpson"))
                        .build());


        this.personService.createPersons(personMapper.personEntityToPersonDto(person));
    }

    private Person getPersonFromData(String id, String name, String lastName) {
        return Person.builder().id(null).name(name).lastName(lastName).birthDate(LocalDate.now()).build();
    }

}
