package com.kodecamp.student.ui;

import com.kodecamp.commons.ui.Message;
import com.kodecamp.commons.ui.MessageUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class is used for urls /student/*.
 *
 * @author kcamp
 */
public final class StudentCtrl {

  private final String rollNo = "default roll no";
  private final String name = "defalt name";
  private final String address = "default address";


  public String getRollNo() {
    return rollNo;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  /**
   * constructor.
   */
  public StudentCtrl() {
    System.out.println("Constructor : StudentCtrl");

  }

  /**
   * This method maps to student/list.xhtml.
   *
   * @param request HttpServletRequest
   * @param response HttpServletResponse
   * @return view
   */
  public String list(final HttpServletRequest request, final HttpServletResponse response) {

    return "/views/student/student_list.jsp";
  }

  /**
   * This method maps to student/addform.xhtml.
   *
   * @param request HttpServletRequest
   * @param response HttpServletResponse
   * @return view
   */
  public String addform(final HttpServletRequest request, final HttpServletResponse response) {
    return "/views/student/add_form.jsp";
  }

  /**
   * This method maps to /student/addnew.xhtml.
   *
   * @param request HttpServletRequest
   * @param response HttpServletResponse
   * @return view
   */
  public String addnew(final HttpServletRequest request, final HttpServletResponse response) {
    MessageUtil.setMessages(request, new Message(Message.MSG_TYPE_ERROR, "Sample Message"),
            new Message(Message.MSG_TYPE_INFO, "Sample Message"));
    return "/student/addform";
  }

}
