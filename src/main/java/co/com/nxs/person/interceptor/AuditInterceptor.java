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
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

/**
 * Audit interceptor
 *
 * @since 1.0.0
 * @version 1.0.0
 * @author <a href="sumel124@gmail.com">Freddy Lemus</a>
 *
 */
@Component
public class AuditInterceptor implements HandlerInterceptor {
    @Autowired
    AuditAsyncService auditService;

    @Override
    public boolean preHandle
            (HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (DispatcherType.REQUEST.name().equals(request.getDispatcherType().name())
                && this.isMethodAvailable(request)) {
            auditService.logInput(
                    String.format(
                            "Method [%s] RemoteAddress: [%s]", request.getMethod(), request.getRemoteAddr()),
                    request.getRequestURI(),
                    LocalDateTime.now(),
                    EventType.INPUT);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion
            (HttpServletRequest request, HttpServletResponse response, Object
                    handler, Exception exception) throws Exception {
    }


    private boolean isMethodAvailable(HttpServletRequest request) {
        return request.getMethod().equals(HttpMethod.GET.name()) ||
                request.getMethod().equals(HttpMethod.DELETE.name());
    }
}