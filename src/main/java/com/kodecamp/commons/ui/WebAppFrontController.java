package com.kodecamp.commons.ui;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is the front controller for all the requests for url patters like *.jsp & *.xhtml.
 *
 * @author kcamp
 */
public final class WebAppFrontController extends HttpServlet {


  /**
   * constructor.
   */
  public WebAppFrontController() {
    System.out.println("### WebAppFrontControllerr : Constructor");
  }

  /**
   * init method : this method is called after constructor.
   *
   * @param config config object
   */
  public void init(final ServletConfig config) {
    System.out.println("### WebAppFrontController : Initialized");
  }

  /**
   * This method processes the get or post requests.
   *
   * @param request httpservlet request
   * @param response httpservlet response
   * @throws ServletException throws exception if something goes wrong
   * @throws IOException throws exception if unable to write response
   */
  protected void processRequest(final HttpServletRequest request, final HttpServletResponse response)
          throws ServletException, IOException {
    System.out.println("=============================Start : Processing request=====================");
    System.out.println("### Request Object : " + request);
    final String requestUri = request.getRequestURI();
    System.out.println("### Request Url : " + request.getRequestURL());
    System.out.println("### Request Uri : " + requestUri);

    System.out.println("### Request Context Path : " + request.getContextPath());

    final String encodedActionUri = requestUri.replace(request.getContextPath(), "");
    int uptoIndex = encodedActionUri.indexOf(";");
    if (uptoIndex < 0) {
      uptoIndex = encodedActionUri.length();
    }
    System.out.println("### Action Uri : " + encodedActionUri.substring(0, uptoIndex));
    final String actionUri = encodedActionUri.substring(0, uptoIndex);
    final StringTokenizer tokenizer = new StringTokenizer(actionUri, "/");
    if (tokenizer.countTokens() < 1) {
      //TODO :
      System.err.println("@@@ Invalid Url Pattern : Atleat one parameter is needed.");
      return;
    }

    String controllerName = tokenizer.nextToken().replace(".xhtml", "");
    String methodName = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "index";
    methodName = methodName.replace(".xhtml", "");
    System.out.println("### Controller Name : " + controllerName);
    System.out.println("### Method Name : " + methodName);

    //      System.out.println("type : " + type.newInstance());
    String view = "";
    try {

      setUpMessages(request);
      setUpMenu(request, response);
      System.out.println("### Before Action Execution");
      Object ctrlObj = preProcessRequest(request, controllerName);
      Method method = ctrlObj.getClass().getMethod(methodName, new Class[]{HttpServletRequest.class, HttpServletResponse.class});
      view = (String) method.invoke(ctrlObj, request, response);
      System.out.println("### After Action Execution");

    } catch (Exception ex) {
      System.err.println("@@@ Something went wrong while resolving url. /\n Please check the mapping.");
//      ex.printStackTrace();
    }

    if (view.startsWith(":")) {
      System.out.println("### Redirection to : " + view);
      response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + view.substring(1)));
      return;
    }
    System.out.println("### Forwarding to : " + view);
    request.getRequestDispatcher(response.encodeURL(view)).forward(request, response);

    System.out.println("### Clearing messages");
    ((List<Message>) request.getSession().getAttribute("messages")).clear();
    System.out.println("================================= End : Processing request===========================");

  }

  /**
   * This method is called before processing the request.
   *
   * @param request HttpServletRequest
   * @param controllerName HttpServletResponse
   * @return object
   */
  public Object preProcessRequest(final HttpServletRequest request, final String controllerName) {
    final HttpSession session = request.getSession();
    System.out.println("### Sessoin : " + session);
    Object ctrlObj = session.getAttribute(controllerName);
    if (ctrlObj == null) {
      ctrlObj = ControllerMapper.getControllerInstance(controllerName);
      session.setAttribute(controllerName, ctrlObj);
    }
    request.setAttribute("defaultformaction", request.getContextPath() + "/" + controllerName);
    System.out.println("### defaultformaction : " + request.getContextPath() + "/" + controllerName);
    System.out.println("### Controller instance created Successfully : " + ctrlObj);
    return ctrlObj;
  }

  /**
   * This method is used for iniitalinng the messages.
   *
   * @param request HttpServletRequest
   */
  private void setUpMessages(final HttpServletRequest request) {
    request.setAttribute("contextPath", request.getContextPath());
    final HttpSession session = request.getSession();
    List<Message> messages = (List<Message>) session.getAttribute("messages");
    if (messages == null || messages.isEmpty()) {
      messages = new ArrayList<Message>();
      session.setAttribute("messages", messages);
    }
  }

  /**
   * This method is used for creating customized menus(after login).
   *
   * @param request HttpServletRequest
   * @param response HttpServletResponse
   */
  private void setUpMenu(final HttpServletRequest request, final HttpServletResponse response) {
    System.out.println("### Setting Up Global Menu From Config Params");
    final HttpSession session = request.getSession();
    Map<String, String> menus = (Map<String, String>) session.getAttribute("menus");
    if (menus == null) {
      menus = new HashMap<>();
      menus.put("Show Colleges",
              response.encodeURL(request.getContextPath() + "/college/list.xhtml"));
      menus.put("Add New College",
              response.encodeURL(request.getContextPath() + "/college/addform.xhtml"));
      session.setAttribute("menus", menus);
    }

  }

  @Override
  protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
