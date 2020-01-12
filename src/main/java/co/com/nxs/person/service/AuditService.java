package co.com.nxs.person.service;

import co.com.nxs.person.entities.Audit;
import co.com.nxs.person.enums.EventType;
import co.com.nxs.person.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditService {

    private AuditRepository auditRepository;

    @Autowired
    public AuditService(AuditRepository loggerRepository) {
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
