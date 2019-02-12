/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kodecamp.filters;

import com.kodecamp.user.db.UserInfo;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "WebSecurityFilter", urlPatterns = {"*.jsp", "*.xhtml"},
        initParams = {
          @WebInitParam(name = "EXCLUDED_URLS", value = "/views/public,/css")})
public class WebSecurityFilter implements Filter {

  private static final String className = WebSecurityFilter.class.getName();

  public WebSecurityFilter() {
    System.out.println("$$$$ : Created : AuthenticationFilter");
  }

  @Override
  public void doFilter(ServletRequest request,
          ServletResponse response, FilterChain chain) throws IOException, ServletException {

    final HttpServletRequest httpReq = (HttpServletRequest) request;

    // checks for static resources and public urls
    if (isPublicResourceRequest(httpReq)) {
      System.out.println(className + " : ### : Processing Public Request....");
      try {
        chain.doFilter(request, response);
      } catch (Exception ex) {
        System.err.println(className + " @@@ Something went wrong while processing request : " + httpReq.getRequestURI());
      }
      return;
    }

    if (!isAlreadyLoggedIn(httpReq)) {
      System.out.println(className + " Not a valid user forwarding request to login page");
      request.getRequestDispatcher(httpReq.getContextPath() + "/publicpages/loginform.xhtml").forward(request, response);
      return;
    }
    chain.doFilter(request, response);

  }

  private boolean isPublicResourceRequest(final HttpServletRequest httpReq) {
    final String requestUri = httpReq.getRequestURI();
    if (requestUri.startsWith(httpReq.getContextPath() + "/publicpages")
            || requestUri.startsWith(httpReq.getContextPath() + "/views")) {
      return true;
    }
    return false;
  }

  private boolean isAlreadyLoggedIn(final HttpServletRequest httpReq) {
    final UserInfo userInSession = (UserInfo) httpReq.getSession().getAttribute("userInfo");
    System.out.println(className + " ### : Already Logged in : " + userInSession);
    System.out.println(className + " ### : Session : " + httpReq.getSession());
    return userInSession == null ? false : true;
  }


  @Override
  public void destroy() {
    System.out.println("$$$$ : Destroyed : AuthenticationFilter");
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
//    final String pathPrefixes = filterConfig.getInitParameter("EXCLUDED_PAGES");
//    System.out.println("xxxxxxxxxxxxxxxxxxxxxx " + pathPrefixes);
//    if ("".equals(pathPrefixes)) {
//      return;
//    }
//    StringTokenizer tokenizer = new StringTokenizer(pathPrefixes, ",");
//    List<String> tokens = new ArrayList<>();
//    while (tokenizer.hasMoreTokens()) {
//      tokens.add(tokenizer.nextToken());
//    }
//    this.execudedPaths = tokens;
  }

}
