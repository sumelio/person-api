package co.com.nxs.person.dto;

import co.com.nxs.person.enums.ResponseCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto<T> {
    private long code;
    private String message;
    private ResponseCode responseCode;
    private T data;
}
