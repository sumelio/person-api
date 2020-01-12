/*
 *
 *  *   Copyright 2020, Nexos Software S.A.S
 *  *   https://nxs.com.co/
 *  *
 *  *   All rights reserved
 *  *   Date: 12/02/2020
 *
 *
 */

package co.com.nxs.person.handler;

import co.com.nxs.person.constant.MessageConstant;
import co.com.nxs.person.dto.ResponseDto;
import co.com.nxs.person.enums.EventType;
import co.com.nxs.person.handler.customeException.PersonNotFound;
import co.com.nxs.person.service.AuditAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

/**
 * Handlers Advice Rest Exception
 *
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="sumel124@gmail.com">Freddy Lemus</a>
 *
 */
@RestControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler {

    @Autowired
    private AuditAsyncService loggerService;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleException(Exception ex) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String errorDetail = MessageConstant.GENERAL_ERROR_MESSAGE;
        log.error(ex.getLocalizedMessage(), ex);

        loggerService.log(String.format("[%S]: $%",status.name(),ex.getMessage()), LocalDateTime.now(), EventType.ERROR);

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
        log.error(ex.getLocalizedMessage(), ex);

        loggerService.log(String.format("[%s]: %s",status.name(),ex.getMessage()), LocalDateTime.now(), EventType.FAIL);

        return ResponseEntity
                .status(status)
                .body(ResponseDto.<String>builder()
                        .message(ex.getMessage())
                        .code(status.value())
                        .build());
    }
}
