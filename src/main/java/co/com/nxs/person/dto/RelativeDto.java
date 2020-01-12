package co.com.nxs.person.dto;

import co.com.nxs.person.entities.Person;
import co.com.nxs.person.enums.RelativeType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelativeDto {
    private RelativeType relativeType;
    private PersonDto person;
}
