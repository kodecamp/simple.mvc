package com.kodecamp.publicpages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PublicPagesCtrl {

  // default action
  // /publicpages.xhtml
  public String index(final HttpServletRequest request, final HttpServletResponse response) {
    return "/views/home.jsp";
  }

//  /publicpages/home.xhtml
  public String home(final HttpServletRequest request, final HttpServletResponse response) {
    return this.index(request, response);
  }

  public String contact(final HttpServletRequest request, final HttpServletResponse response) {
    return "/views/contactus.jsp";
  }

  public String courses(final HttpServletRequest request, final HttpServletResponse response) {
    return "/views/courses.jsp";
  }

  public String loginform(final HttpServletRequest request, final HttpServletResponse response) {
    return "/views/login_form.jsp";
  }

  public String login(HttpServletRequest req, HttpServletResponse resp) {
    // forward the request to auth ctrl
    return "/auth/login.xhtml";
  }

}
