package co.com.nxs.person.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
	private String id;
	private String name;
	private String lastName;
	private LocalDate birthDate;
	private List<RelativeDto> relatives;
}
