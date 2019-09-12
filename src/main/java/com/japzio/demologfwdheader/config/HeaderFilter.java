package com.japzio.demologfwdheader.config;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeaderFilter implements Filter {

  @Value("${logging.header:X-Request-ID}")
  private String headerName;
  private MDC mappedDiagnosticContext;

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    try {
      mappedDiagnosticContext.put(headerName, ((HttpServletRequest) servletRequest).getHeader(headerName));
      mappedDiagnosticContext.put(headerName, ((HttpServletResponse) servletResponse).getHeader(headerName));
      filterChain.doFilter(servletRequest, servletResponse);
    } finally {
      mappedDiagnosticContext.clear();
    }

  }

}
