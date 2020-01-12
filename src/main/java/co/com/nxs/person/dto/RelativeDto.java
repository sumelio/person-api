package co.com.nxs.person.dto;

import co.com.nxs.person.entities.Person;
import co.com.nxs.person.enums.RelativeType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelativeDto {
    private RelativeType relativeType;
    // private PersonDto person;
}
