package com.kodecamp.commons.ui;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author kcamp
 */
public class MessageUtil {
  public static List<Message> getMessages(final HttpServletRequest request) {
    List<Message> messages = (List<Message>) request.getSession().getAttribute("messages");
    return messages;
  }

  public static void setMessages(final HttpServletRequest request, final Message... msgs) {

    List<Message> messages = (List<Message>) request.getSession().getAttribute("messages");
    messages.clear();
    System.out.println("?????????? messages " + messages);

    Arrays.stream(msgs).forEach((msg) -> {
      messages.add(msg);
    });

  }

  public static void clearMessages(final HttpServletRequest request) {
    List<Message> messages = (List<Message>) request.getSession().getAttribute("messages");
    messages.clear();
  }
}
