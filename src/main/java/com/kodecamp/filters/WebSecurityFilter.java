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

/**
 * This class intercepts the http request for *.jsp and *.xhtml.
 *
 * @author kcamp
 */
@WebFilter(filterName = "WebSecurityFilter", urlPatterns = {"*.jsp", "*.xhtml"},
        initParams = {
          @WebInitParam(name = "EXCLUDED_URLS", value = "/views/public,/css")})
public final class WebSecurityFilter implements Filter {

  private static final String CLASS = WebSecurityFilter.class.getName();

  /**
   * constructor.
   */
  public WebSecurityFilter() {
    System.out.println("$$$$ : Created : AuthenticationFilter");
  }

  @Override
  public void doFilter(final ServletRequest request,
          final ServletResponse response, final FilterChain chain)
          throws IOException, ServletException {

    final HttpServletRequest httpReq = (HttpServletRequest) request;

    // checks for static resources and public urls
    if (isPublicResourceRequest(httpReq)) {
      System.out.println(CLASS + " : ### : Processing Public Request....");
      try {
        chain.doFilter(request, response);
      } catch (Exception ex) {
        System.err.println(CLASS + " @@@ Error Occured : " + httpReq.getRequestURI());
      }
      return;
    }

    if (!isAlreadyLoggedIn(httpReq)) {
      System.out.println(CLASS + " Not a valid user forwarding request to login page");
      request.getRequestDispatcher(
              httpReq.getContextPath() + "/publicpages/loginform.xhtml").forward(request, response);
      return;
    }
    chain.doFilter(request, response);

  }

  /**
   * This method checks whether the request is for public resource(/publicpages/* or /views/*.
   *
   * @param httpReq httprequest
   * @return true or false
   */
  private boolean isPublicResourceRequest(final HttpServletRequest httpReq) {
    final String requestUri = httpReq.getRequestURI();
    if (requestUri.startsWith(httpReq.getContextPath() + "/publicpages")
            || requestUri.startsWith(httpReq.getContextPath() + "/views")) {
      return true;
    }
    return false;
  }

  /**
   * This method checks whether the request is authentic or not.
   *
   * @param httpReq request to be checked.
   * @return true or false
   */
  private boolean isAlreadyLoggedIn(final HttpServletRequest httpReq) {
    final UserInfo userInSession = (UserInfo) httpReq.getSession().getAttribute("userInfo");
    System.out.println(CLASS + " ### : Already Logged in : " + userInSession);
    System.out.println(CLASS + " ### : Session : " + httpReq.getSession());
    return userInSession == null ? false : true;
  }

  @Override
  public void destroy() {
    System.out.println("$$$$ : Destroyed : AuthenticationFilter");
  }

  @Override
  public void init(final FilterConfig filterConfig) throws ServletException {
  }

}
