package co.com.nxs.person.entities;

import co.com.nxs.person.enums.RelativeType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "relative")
public class Relative {
    private RelativeType relativeType;
    private Person person;
}
