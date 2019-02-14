package com.kodecamp.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.StringTokenizer;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * This filter is used for logging the request and response.
 *
 * @author kcamp
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = "/disabled/*")
public final class LoggingFilter implements Filter {

  private FilterConfig filterConfig = null;

  /**
   * constructor.
   */
  public LoggingFilter() {
    System.out.println("$$$$ : Created : LogingFilter");
  }

  @Override
  public void init(final FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
    final HttpServletRequest httpRequest = (HttpServletRequest) request;

    final String requestUri = httpRequest.getRequestURI();

    //System.out.println("### Request Url : " + httpRequest.getRequestURL());
    //System.out.println("### Request Uri : " + requestUri);
    //System.out.println("### Request Context Path : " + httpRequest.getContextPath());
    final String encodedActionUri = requestUri.replace(httpRequest.getContextPath(), "");
    //System.out.println("### Action Uri : " + encodedActionUri.substring(0, encodedActionUri.indexOf(";")));
    final String actionUri = encodedActionUri.substring(0, encodedActionUri.indexOf(";"));
    final StringTokenizer tokenizer = new StringTokenizer(actionUri, "/");
    if (tokenizer.countTokens() < 2) {
      System.out.println("");
    }

    Map<String, String[]> paramNameValuesMap = httpRequest.getParameterMap();

    System.out.println("  ## Params : ");
    paramNameValuesMap.forEach((param, values) -> {
      System.out.println("    " + param + " -> " + concatenateValues(values));

    });
    System.out.println("  Params : ## ");

    System.out.println("  ## Request Attributes  ");
    final Enumeration<String> requestAttributes = request.getAttributeNames();

    while (requestAttributes.hasMoreElements()) {
      String el = requestAttributes.nextElement();
      System.out.println(el + " -> " + request.getAttribute(el));
    }

    System.out.println("  Request Attributes : ##");
    chain.doFilter(request, response);
    System.out.println("Request Uri : " + requestUri + " @@");

  }

  /**
   * Not decided.
   *
   * @param values values
   * @return string
   */
  private String concatenateValues(final String[] values) {
    return Arrays.stream(values).reduce((result, value) -> result + "," + value).orElse("");
  }

  @Override
  public void destroy() {
    System.out.println("$$$$ : Destroyed : LogingFilter");
  }

}
