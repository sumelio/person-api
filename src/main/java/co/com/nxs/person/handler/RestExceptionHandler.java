package co.com.nxs.person.handler;

import co.com.nxs.person.controller.MessageConstant;
import co.com.nxs.person.dto.ResponseDto;
import co.com.nxs.person.handler.customeException.PersonNotFound;
import co.com.nxs.person.service.LoggerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler {

    @Autowired
    private LoggerService loggerService;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleException(Exception ex) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String errorDetail = MessageConstant.GENERAL_ERROR_MESSAGE;
        log.error(ex.getLocalizedMessage(), ex);

        loggerService.log(errorDetail, LocalDateTime.now(), status.name());

        return ResponseEntity
                .status(status)
                .body(ResponseDto.<String>builder()
                        .message(errorDetail)
                        .code(status.value())
                        .build());
    }

    @ExceptionHandler(PersonNotFound.class)
    public ResponseEntity<ResponseDto> handlePersonNotFound(PersonNotFound ex) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        String errorDetail = MessageConstant.PERSON_NOT_FOUND;
        log.error(ex.getLocalizedMessage(), ex);

        loggerService.log(errorDetail, LocalDateTime.now(), status.name());

        return ResponseEntity
                .status(status)
                .body(ResponseDto.<String>builder()
                        .message(errorDetail)
                        .code(status.value())
                        .build());
    }



}
