package com.kodecamp.commons.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author kcamp
 */
public class ValidationUtil {

  static public boolean isEmpty(final String value) {
    if (value == null || value.trim().equals("")) {
      return true;
    }
    return false;
  }
  
  static public boolean isAnyEmpty(final Boolean ...values) {
    return Arrays.stream(values).anyMatch(value-> value == true);
  }
  
  static public boolean isAnyEmpty(final String ...values) {
    return Arrays.stream(values).map((value)-> isEmpty(value)).anyMatch(value-> value == true);
  }
  
  static public boolean validate(final Boolean ...values) {
    return Arrays.stream(values).anyMatch(value-> value == true);
  }
  
  public static <T> boolean isPresent(final T obj,final List<T> objList) {
		boolean isExist = (objList.contains(obj)? true : false);
		 return isExist ;
	}
  
  
}
