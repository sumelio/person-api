package co.com.nxs.person.listener;

import co.com.nxs.person.entities.Person;
import co.com.nxs.person.entities.Relative;
import co.com.nxs.person.enums.RelativeType;
import co.com.nxs.person.mapper.PersonMapper;
import co.com.nxs.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SeedPersonEventListener {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonMapper personMapper;

    public void seed(ContextRefreshedEvent event) {
        seedPersonDocument();
    }

    @EventListener
    private void seedPersonDocument() {

        Person person =
                Person.builder()
                        .birthDate(LocalDate.now())
                        .id("1000001")
                        .name("Bart")
                        .lastName("Simpson")
                        .build();

        person.getRelatives().add(
                Relative.builder()
                        .relativeType(RelativeType.SISTER)
                        //.person(getPersonFromData("100004", "Lisa", "Simpson"))
                        .build()
        );

        person.getRelatives().add(
                Relative.builder()
                        .relativeType(RelativeType.SISTER)
                       // .person(getPersonFromData("100004", "Maggie", "Simpson"))
                        .build());

        person.getRelatives().add(
                Relative.builder()
                        .relativeType(RelativeType.MOTHER)
                        //.person(getPersonFromData("100004", "Marge", "Simpson"))
                        .build());

        person.getRelatives().add(
                Relative.builder()
                        .relativeType(RelativeType.FATHER)
                       // .person(getPersonFromData("100004", "Homero", "Simpson"))
                        .build());

        person.getRelatives().add(
                Relative.builder()
                        .relativeType(RelativeType.GRANDFATHER)
                        //.person(getPersonFromData("100004", "Abraham", "Simpson"))
                        .build());


        this.personService.createPersons(personMapper.personEntityToPersonDto(person));
    }

    private Person getPersonFromData(String id, String name, String lastName) {
        return Person.builder().id(id).name(name).lastName(lastName).build();
    }

}
