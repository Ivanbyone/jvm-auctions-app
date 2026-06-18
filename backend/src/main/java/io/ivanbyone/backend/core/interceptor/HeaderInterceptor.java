package io.ivanbyone.backend.core.interceptor;

import io.ivanbyone.backend.core.error.HeaderValidationException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Optional;

@Component
public class HeaderInterceptor implements HandlerInterceptor {

    private static final String X_FROM_SYSTEM = "X-From-System";
    private static final String X_TO_SYSTEM = "X-To-System";
    private static final String X_TRACE_ID = "X-Trace-ID";

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // Setup Trace-ID for response
        Optional.ofNullable(request.getHeader(X_TRACE_ID))
                .ifPresentOrElse(
                        value -> response.setHeader(X_TRACE_ID, value),
                        () -> { throw new HeaderValidationException("Header 'X-Trace-ID' is required"); }
                );

        Optional.ofNullable(request.getHeader(X_FROM_SYSTEM))
                .ifPresentOrElse(
                        value -> response.setHeader(X_TO_SYSTEM, value),
                        () -> { throw new HeaderValidationException("Header 'X-From-System' is required"); }
                );

        Optional.ofNullable(request.getHeader(X_TO_SYSTEM))
                .ifPresentOrElse(
                        value -> response.setHeader(X_FROM_SYSTEM, value),
                        () -> { throw new HeaderValidationException("Header 'X-To-System' is required"); }
                );

        return true;
    }
}
