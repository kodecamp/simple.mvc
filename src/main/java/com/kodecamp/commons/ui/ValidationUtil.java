package com.kodecamp.commons.ui;

import java.util.Arrays;
import java.util.List;

/**
 * This class is used for common validation rulles.
 *
 * @author kcamp
 */
public final class ValidationUtil {

  /**
   * private constructor.
   */
  private ValidationUtil() {
  }

  /**
   * checks for empty value.
   *
   * @param value value to be checked
   * @return true if value is empty
   */
  public static boolean isEmpty(final String value) {
    if (value == null || value.trim().equals("")) {
      return true;
    }
    return false;
  }

  /**
   * checks for empty value.
   *
   * @param values values to be checked
   * @return true if any value is empty
   */
  public static boolean isAnyEmpty(final Boolean... values) {
    return Arrays.asList(values).contains(true);
  }

  /**
   * checks for empty value.
   *
   * @param values values to be checked
   * @return true if any value is empty
   */
  public static boolean isAnyEmpty(final String... values) {
    return Arrays.stream(values).anyMatch(ValidationUtil::isEmpty);
  }

  /**
   * checks for empty value.
   *
   * @param values values to be checked
   * @return true if any value is empty
   */
  public static boolean validate(final Boolean... values) {
    return isAnyEmpty(values);
  }

  /**
   * this method checks whether value is prsent or not.
   *
   * @param <T> type of value to be checked
   * @param obj value to be checked
   * @param objList values
   * @return boolean
   */
  public static <T> boolean isPresent(final T obj, final List<T> objList) {
    boolean isExist = (objList.contains(obj) ? true : false);
    return isExist;
  }

}
