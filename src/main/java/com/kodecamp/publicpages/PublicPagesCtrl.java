package com.kodecamp.publicpages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class is used for mapping public action(/publicpages/.
 *
 * @author kcamp
 */
public final class PublicPagesCtrl {

  /**
   * This method maps to publicpages.xhtml.
   *
   * @param request HttpServletRequest
   * @param response HttpServletResponse
   * @return view
   */
  public String index(final HttpServletRequest request, final HttpServletResponse response) {
    return "/views/home.jsp";
  }

  /**
   * This method maps to publicpages/home.xhtml.
   *
   * @param request HttpServletRequest
   * @param response HttpServletResponse
   * @return view
   */
  public String home(final HttpServletRequest request, final HttpServletResponse response) {
    return this.index(request, response);
  }

  /**
   * This method maps to publicpages/contact.xhtml.
   *
   * @param request HttpServletRequest
   * @param response HttpServletResponse
   * @return view
   */
  public String contact(final HttpServletRequest request, final HttpServletResponse response) {
    return "/views/contactus.jsp";
  }

  /**
   * This method maps to publicpages/courses.xhtml.
   *
   * @param request HttpServletRequest
   * @param response HttpServletResponse
   * @return view
   */
  public String courses(final HttpServletRequest request, final HttpServletResponse response) {
    return "/views/courses.jsp";
  }

  /**
   * This method maps to publicpages/loginform.xhtml.
   *
   * @param request HttpServletRequest
   * @param response HttpServletResponse
   * @return view
   */
  public String loginform(final HttpServletRequest request, final HttpServletResponse response) {
    return "/views/login_form.jsp";
  }

  /**
   * This method maps to publicpages/login.xhtml.
   *
   * @param request HttpServletRequest
   * @param response HttpServletResponse
   * @return view
   */
  public String login(final HttpServletRequest request, final HttpServletResponse response) {
    // forward the request to auth ctrl
    return "/auth/login.xhtml";
  }

}
