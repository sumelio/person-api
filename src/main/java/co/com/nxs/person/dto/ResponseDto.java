package co.com.nxs.person.dto;

import co.com.nxs.person.enums.ResponseCode;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {
    private long code;
    private String message;
    private ResponseCode responseCode;
    private T data;
}
