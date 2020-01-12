package co.com.nxs.person.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "person")
public class Person {
	@Id
	private String id;
	private String name;
	private String lastName;
	private LocalDate birthDate;
	private List<Relative> relatives;
}
