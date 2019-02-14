package com.kodecamp.commons.ui;

import com.kodecamp.college.ui.CollegeCtrl;
import com.kodecamp.login.ui.AuthCtrl;
import com.kodecamp.publicpages.PublicPagesCtrl;
import com.kodecamp.student.ui.StudentCtrl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is used for usr to controller class mapping.
 *
 * @author kcamp
 */
public final class ControllerMapper {

  /**
   * constructor.
   */
  private ControllerMapper() {
  }

  private static Map<String, Object> controllerMap = new HashMap<>();

  // static block : will be executed on class load time
  // before constructor
  static {
    System.out.println("### Controller Mappings Loaded....");
    controllerMap.put("college", new CollegeCtrl());
    controllerMap.put("student", new StudentCtrl());
    controllerMap.put("auth", new AuthCtrl());
    controllerMap.put("publicpages", new PublicPagesCtrl());
  }

  /**
   * This method returns the instance of controller class.
   *
   * @param controllerName name
   * @return Instance of mapped controller
   */
  public static Object getControllerInstance(final String controllerName) {
    try {
      return controllerMap.get(controllerName).getClass().newInstance();
    } catch (Exception ex) {
      Logger.getLogger(ControllerMapper.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
}
