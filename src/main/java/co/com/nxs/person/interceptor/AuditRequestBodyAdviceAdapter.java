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

package co.com.nxs.person.interceptor;

import co.com.nxs.person.enums.EventType;
import co.com.nxs.person.service.AuditAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;
import java.time.LocalDateTime;

/**
 * Audit Interceptor for Request body
 *
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="sumel124@gmail.com">Freddy Lemus</a>
 *
 */

@ControllerAdvice
public class AuditRequestBodyAdviceAdapter extends RequestBodyAdviceAdapter {

    @Autowired
    AuditAsyncService auditService;

    @Autowired
    HttpServletRequest request;

    @Override
    public boolean supports(MethodParameter methodParameter, Type type,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage,
                                MethodParameter parameter, Type targetType,
                                Class<? extends HttpMessageConverter<?>> converterType) {
        if (DispatcherType.REQUEST.name().equals(request.getDispatcherType().name())
                && this.isMethodSupport(request)) {
            auditService.logInput(
                    String.format(
                            "Method [%s] RemoteAddress: [%s]", request.getMethod(), request.getRemoteAddr()),
                    body.toString(),
                    LocalDateTime.now(),
                    EventType.INPUT);
        }

        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }

    private boolean isMethodSupport(HttpServletRequest request) {
        return request.getMethod().equals(HttpMethod.POST.name()) ||
                request.getMethod().equals(HttpMethod.PUT.name())||
                request.getMethod().equals(HttpMethod.PATCH.name());
    }
}