/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kodecamp.college.ui;

import com.kodecamp.college.db.College;
import com.kodecamp.commons.ui.Message;
import com.kodecamp.commons.ui.MessageUtil;
import com.kodecamp.commons.ui.ValidationUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// simple class
public class CollegeCtrl {
  // fields

  private String value1 = "Value 1";
  private String value2 = "Value 2";
  private String value3 = "Value 3";
  private String value4 = "Value 4 : This value is coming from controller";

  private static final String viewPathPrefix = "/views/college";
  private final List<UICollege> collegeList = new ArrayList<>();

  public String list(HttpServletRequest req, HttpServletResponse resp) {
//    final HttpSession session = req.getSession();
//    final List<UICollege> list = (List<UICollege>) session.getAttribute("collegeList");
    final String contextPath = req.getContextPath();
    if (this.collegeList.isEmpty()) {
      this.collegeList.addAll(createDummyList(req, resp));
    }
//      session.setAttribute("collegeList", colleges);
    return this.viewPathPrefix + "/college_list.jsp";
  }

  private List<UICollege> createDummyList(final HttpServletRequest request, final HttpServletResponse resp) {
    final String contextPath = request.getContextPath();
    final List<UICollege> dummyColleges = new ArrayList<>();
    final UICollege college1 = new UICollege(new College("sar001", "Saroj Institute", "Lucknow"), contextPath);
    college1.setDeleteUrl(resp.encodeURL(college1.getDeleteUrl()));
    college1.setUpdateUrl(resp.encodeURL(college1.getUpdateUrl()));

    final UICollege college2 = new UICollege(new College("bbd001", "Babu Banarasi Das", "Lucknow"), contextPath);
    college2.setDeleteUrl(resp.encodeURL(college2.getDeleteUrl()));
    college2.setUpdateUrl(resp.encodeURL(college2.getUpdateUrl()));

    final UICollege college3 = new UICollege(new College("azd001", "Azad Institue", "Kanpur"), contextPath);
    college3.setDeleteUrl(resp.encodeURL(college3.getDeleteUrl()));
    college3.setUpdateUrl(resp.encodeURL(college3.getUpdateUrl()));

    dummyColleges.add(college1);
    dummyColleges.add(college2);
    dummyColleges.add(college3);
    return dummyColleges;
  }

  public String addform(final HttpServletRequest req, final HttpServletResponse resp) {
//    MessageUtil.clearMessages(req);
    return this.viewPathPrefix + "/college_form.jsp";
  }

  public String addnew(final HttpServletRequest req, final HttpServletResponse resp) {
    String regNo = req.getParameter("regNo");
    String name = req.getParameter("name");
    String address = req.getParameter("address");

    if (isValidOrDuplicate(req)) {
      MessageUtil.setMessages(req, new Message(Message.MSG_TYPE_ERROR, "Please enter the mandatory(*) fields."));
      return "/college/addform.xhtml?" + "regNo=" + regNo + "&name=" + name + "&address=" + address;
    }

    if (this.collegeList.contains(new UICollege(new College(regNo, name, address), ""))) {
      MessageUtil.setMessages(req, new Message(Message.MSG_TYPE_ERROR, "Already exists. Please enter the new record."));
      return "/college/addform.xhml?" + "regNo=" + regNo + "&name=" + name + "&address=" + address;
    }

    return addValues(req, resp);

  }

  private boolean isValidOrDuplicate(final HttpServletRequest req) {

    final String regNo = req.getParameter("regNo");
    final String name = req.getParameter("name");
    final String address = req.getParameter("address");

    final boolean isRegNoEmpty = ValidationUtil.isEmpty(regNo);
    final boolean isNameEmpty = ValidationUtil.isEmpty(name);
    final boolean isAddressEmpty = ValidationUtil.isEmpty(address);

//	    final boolean isAnyEmpty = ValidationUtil.isAnyEmpty(isNameEmpty, isAddressEmpty);
    final boolean isAnyEmpty = (ValidationUtil.isAnyEmpty(isRegNoEmpty, isNameEmpty, isAddressEmpty) || ValidationUtil.isPresent(new UICollege(new College(regNo), ""), this.collegeList));
    System.out.println("Value of IS ANY EMPTY  " + isAnyEmpty);
    return isAnyEmpty;
  }

  private String addValues(final HttpServletRequest req, final HttpServletResponse resp) {

    final UICollege newCollege = new UICollege(new College(req.getParameter("regNo"), req.getParameter("name"), req.getParameter("address")), req.getContextPath());
    newCollege.setDeleteUrl(resp.encodeURL(newCollege.getDeleteUrl()));
    newCollege.setUpdateUrl(resp.encodeURL(newCollege.getUpdateUrl()));
    this.collegeList.add(newCollege);
    MessageUtil.setMessages(req, new Message(Message.MSG_TYPE_INFO, "Record added successfully."));
    return ":/college/list.xhtml";
  }

  public String updateform(final HttpServletRequest request, final HttpServletResponse response) {

    final UICollege college = this.collegeList.get(this.collegeList.indexOf(
            new UICollege(new College(request.getParameter("regNo")), null)));
    request.setAttribute("uicollege", college);

    return this.viewPathPrefix + "/college_update_form.jsp";
  }

  public String update(final HttpServletRequest req, final HttpServletResponse resp) {

    UICollege collegeObj = new UICollege(new College(req.getParameter("regNo")), "");

    int indexOfObj = this.collegeList.indexOf(collegeObj);
    UICollege fetchedCollegeObj = this.collegeList.get(indexOfObj);

    // update college with request values
    fetchedCollegeObj.getCollege().setName(req.getParameter("name"));
    fetchedCollegeObj.getCollege().setAddress(req.getParameter("address"));

    // set the updated object in request scope
    req.setAttribute("uicollege", fetchedCollegeObj);

    // on the basis of validity
    String view = isValidForm(req)
            ? onSuccess(req)
            : onFailure(req);
    return view;
  }

  private String onSuccess(final HttpServletRequest req) {
    MessageUtil.setMessages(req, new Message(Message.MSG_TYPE_INFO, "Record Updated Successfully."));
    System.out.println("OnSuccess : Messages : " + req.getAttribute("messages"));
    return ":/college/list.xhtml";
  }

  private String onFailure(final HttpServletRequest req) {
    MessageUtil.setMessages(req, new Message(Message.MSG_TYPE_ERROR, "Please fill the reqired (*) fields."));
    System.out.println("OnFailure : Messages : " + req.getAttribute("messages"));
    return "/college/updateform.xhtml?regNo=" + req.getParameter("regNo");
  }

  private boolean isValidForm(final HttpServletRequest req) {

    final String regNo = req.getParameter("regNo");
    final String newName = req.getParameter("name");
    final String newAddress = req.getParameter("address");

    final boolean isRegNoEmpty = ValidationUtil.isEmpty(regNo);
    final boolean isNameEmpty = ValidationUtil.isEmpty(newName);
    final boolean isAddressEmpty = ValidationUtil.isEmpty(newAddress);

    final boolean isAnyEmpty = ValidationUtil.isAnyEmpty(isNameEmpty, isAddressEmpty);
    return !isAnyEmpty;

  }

  public String delete(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {

    final String regNo = req.getParameter("regNo");
    UICollege clgObj = new UICollege(new College(regNo), "");
    System.out.println("College Object : " + clgObj);
    int indexOfclgObj = this.collegeList.indexOf(clgObj);
    System.out.println("index of College" + indexOfclgObj);
    this.collegeList.remove(indexOfclgObj);
    return ":/college/list.xhtml";
  }

  public String getValue1() {
    return value1;
  }

  public String getValue2() {
    return value2;
  }

  public String getValue3() {
    return value3;
  }

  public String getValue4() {
    return value4;
  }

  public List<UICollege> getCollegeList() {
    return collegeList;
  }

}
