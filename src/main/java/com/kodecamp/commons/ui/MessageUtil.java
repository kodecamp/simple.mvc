package com.kodecamp.commons.ui;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 * This is a utility class for managing messages.
 *
 * @author kcamp
 */
public final class MessageUtil {

  /**
   * private constructor.
   */
  private MessageUtil() {
  }

  /**
   * This method returns all the messages of the context.
   *
   * @param request httpRequest
   * @return list of messages
   */
  public static List<Message> getMessages(final HttpServletRequest request) {
    List<Message> messages = (List<Message>) request.getSession().getAttribute("messages");
    return messages;
  }

  /**
   * This method is used for setting messages.
   *
   * @param request http request
   * @param msgs messages
   */
  public static void setMessages(final HttpServletRequest request, final Message... msgs) {

    List<Message> messages = (List<Message>) request.getSession().getAttribute("messages");
    messages.clear();
    System.out.println("?????????? messages " + messages);

    Arrays.stream(msgs).forEach((msg) -> {
      messages.add(msg);
    });

  }

  /**
   * clears messages.
   *
   * @param request http request
   */
  public static void clearMessages(final HttpServletRequest request) {
    List<Message> messages = (List<Message>) request.getSession().getAttribute("messages");
    messages.clear();
  }
}
