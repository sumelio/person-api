package co.com.nxs.person.dto;

import co.com.nxs.person.constant.MessageConstant;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
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
