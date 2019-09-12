package com.japzio.demologfwdheader.config;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class HeaderFilter implements Filter {

  @Value("${logging.custom-header:X-Request-ID}")
  private String extraHeader;

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    try {
      MDC.put(extraHeader, ((HttpServletRequest)servletRequest).getHeader(extraHeader));
      ((HttpServletResponse) servletResponse).setHeader(extraHeader, ((HttpServletRequest)servletRequest).getHeader(extraHeader));
      filterChain.doFilter(servletRequest, servletResponse);
    } finally {
      MDC.clear();
    }

  }
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}
  @Override
  public void destroy() {}

}
