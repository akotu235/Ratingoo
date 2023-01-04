package io.github.akotu235.Ratingoo.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggerFilter implements Filter {
    public static final Logger logger = LoggerFactory.getLogger(LoggerFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest httpRequest) {
            String ipAddress = httpRequest.getHeader("X-FORWARDED-FOR");
            if (ipAddress == null) {
                ipAddress = httpRequest.getRemoteAddr();
            }
            logger.info("[Request logger] Method: " + httpRequest.getMethod() + ", RequestURI: " + httpRequest.getRequestURI() + ", RemoteAddr: " + ipAddress);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
