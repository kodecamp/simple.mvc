package com.kodecamp.commons.ui;

import java.io.Serializable;

/**
 * This class represents messsage.
 *
 * @author kcamp
 */
public final class Message implements Serializable {

  private final String severity;
  private final String content;
  public static final String MSG_TYPE_ERROR = "error";
  public static final String MSG_TYPE_INFO = "info";

  /**
   * constructor.
   *
   * @param severity level of message
   * @param content content of message
   */
  public Message(final String severity, final String content) {
    this.severity = severity;
    this.content = content;
  }

  public String getSeverity() {
    return severity;
  }

  public String getContent() {
    return content;
  }

}
