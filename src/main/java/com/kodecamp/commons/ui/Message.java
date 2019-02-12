package com.kodecamp.commons.ui;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author kcamp
 */
public class Message implements Serializable {
  private final String severity;
  private final String content;
  public static final String MSG_TYPE_ERROR = "error";
  public static final String MSG_TYPE_INFO = "info";
  
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
