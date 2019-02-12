/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kodecamp.student.ui;

import com.kodecamp.commons.ui.Message;
import com.kodecamp.commons.ui.MessageUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kcamp
 */
public class StudentCtrl {

  private String rollNo = "default roll no";
  private String name = "defalt name";
  private String address = "default address";


  public String getRollNo() {
    return rollNo;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public StudentCtrl() {
    System.out.println("Constructor : StudentCtrl");

  }

  public String list(final HttpServletRequest request, final HttpServletResponse response) {

    return "/views/student/student_list.jsp";
  }

  public String addform(final HttpServletRequest request, final HttpServletResponse response) {
    this.rollNo = "20";
    return "/views/student/add_form.jsp";
  }

  public String addnew(final HttpServletRequest request, final HttpServletResponse response) {
    MessageUtil.setMessages(request, new Message(Message.MSG_TYPE_ERROR, "Sample Message"),
            new Message(Message.MSG_TYPE_INFO, "Sample Message"));
    return "/student/addform";
  }

}
