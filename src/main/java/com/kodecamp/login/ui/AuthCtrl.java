package com.kodecamp.login.ui;

import com.kodecamp.college.db.Db;
import com.kodecamp.commons.ui.Message;
import com.kodecamp.commons.ui.MessageUtil;
import com.kodecamp.commons.ui.ValidationUtil;
import com.kodecamp.user.db.UserInfo;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class handles the reuqest for login and logout.
 *
 * @author kcamp
 */
public final class AuthCtrl {

  private static final long serialVersionUID = 1L;

  /**
   * This is the default method.
   *
   * @param request httprequest
   * @param response httpresponse
   * @return view
   */
  public String index(final HttpServletRequest request, final HttpServletResponse response) {
    return "";
  }

  /**
   * This method is mapped to /auth/login.xhtml.
   *
   * @param req httpservletrequest
   * @param resp httpservletResponse
   * @return view
   */
  public String login(final HttpServletRequest req, final HttpServletResponse resp) {
    System.out.println("Do Post called : ");
    final String view = ":/publicpages/loginform.xhtml";
    if (!isValidForm(req, resp)) {
      MessageUtil.setMessages(req,
              new Message(Message.MSG_TYPE_ERROR, "Please fill the required (*) fields."));
      return view;
    }

    final Optional<UserInfo> optUserInfo = Db.findUserInfo(req.getParameter("userName"),
             req.getParameter("password"));
    if (!optUserInfo.isPresent()) {
      MessageUtil.setMessages(req,
              new Message(Message.MSG_TYPE_ERROR, "Please enter a valid username and password"));
      return view;
    }

    final HttpSession session = req.getSession();
    System.out.println("### Login Successfull. User is set in session " + session);
    System.out.println("### User found : " + optUserInfo.get());
    session.setAttribute("userInfo", optUserInfo.get());
    // redirect to /college/list.xhtml
    return ":/college/list.xhtml";

  }

  /**
   * This method is mapped to /auth/logout.xhtml.
   *
   * @param request HttpServletRequest
   * @param response HttpServletResponse
   * @return view
   */
  public String logout(final HttpServletRequest request, final HttpServletResponse response) {
    final HttpSession session = request.getSession();

    // set the user info to null
    // actually this is not needed but to be safer side do this
    session.setAttribute("userInfo", null);
    // destroy the current session object
    session.invalidate();
    return ":/publicpages/loginform.xhtml";
  }

  /**
   * validates the form.
   *
   * @param req HttpServletRequest
   * @param resp HttpServletResponse
   * @return boolean
   */
  private boolean isValidForm(final HttpServletRequest req, final HttpServletResponse resp) {

    final String username = req.getParameter("userName");
    final String password = req.getParameter("password");
    final boolean isAnyEmpty = ValidationUtil.isAnyEmpty(username, password);
    return isAnyEmpty;
  }

}
