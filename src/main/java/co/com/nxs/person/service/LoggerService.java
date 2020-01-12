package co.com.nxs.person.service;

import co.com.nxs.person.entities.Logger;
import co.com.nxs.person.repository.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoggerService {

    private LoggerRepository loggerRepository;

    @Autowired
    public LoggerService(LoggerRepository loggerRepository) {
        this.loggerRepository = loggerRepository;
    }

    @Async
    public void log(String message, LocalDateTime time, String eventType) {
        loggerRepository.save(Logger
                .builder()
                .eventType(eventType)
                .message(message)
                .time(time)
                .build());
    }
}
