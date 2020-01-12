package co.com.nxs.person.interceptor;

import co.com.nxs.person.enums.EventType;
import co.com.nxs.person.service.AuditService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
public class AuditInterceptor implements HandlerInterceptor {
    @Autowired
    AuditService auditService;

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