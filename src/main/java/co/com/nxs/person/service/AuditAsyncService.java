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

package co.com.nxs.person.service;

import co.com.nxs.person.entities.Audit;
import co.com.nxs.person.enums.EventType;
import co.com.nxs.person.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Audit Async Service
 *
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="sumel124@gmail.com">Freddy Lemus</a>
 *
 */
@Service
public class AuditAsyncService {

    private AuditRepository auditRepository;

    @Autowired
    public AuditAsyncService(AuditRepository loggerRepository) {
        this.auditRepository = loggerRepository;
    }

    @Async
    public void log(String message, LocalDateTime time, EventType eventType) {
        auditRepository.save(Audit
                .builder()
                .eventType(eventType.name())
                .message(message)
                .time(time)
                .build());
    }

    @Async
    public void logInput(String message, String input, LocalDateTime time, EventType eventType) {
        auditRepository.save(Audit
                .builder()
                .eventType(eventType.name())
                .message(message)
                .time(time)
                .inputParams(input)
                .build());
    }


    @Async
    public void logOutput(String message, String output, LocalDateTime time, EventType eventType) {
        auditRepository.save(Audit
                .builder()
                .eventType(eventType.name())
                .message(message)
                .time(time)
                .outputParams(output)
                .build());
    }
}
