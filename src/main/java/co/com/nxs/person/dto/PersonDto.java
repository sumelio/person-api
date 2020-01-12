package co.com.nxs.person.dto;

import co.com.nxs.person.controller.MessageConstant;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDto {
	private String id;
	@NotNull(message = MessageConstant.NAME_CANNOT_NULL)
	private String name;
	private String lastName;
	private LocalDate birthDate;
	private List<RelativeDto> relatives;
}
