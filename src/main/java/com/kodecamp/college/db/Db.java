package com.kodecamp.college.db;

import com.kodecamp.user.db.UserInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Db {

  private static List<UserInfo> users = new ArrayList<>();

  static {
    users.add(new UserInfo("admin", "admin"));
    users.add(new UserInfo("sunil", "sunil"));
    users.add(new UserInfo("sushil", "sushil"));
  }

  public static boolean isValidUser(final String userName, final String password) {
//		boolean result = false;

    final UserInfo userAuthObj = new UserInfo(userName, password);
    System.out.println("user obj : " + userAuthObj);


    final boolean isValid = users.contains(userAuthObj) ? true : false;
    System.out.println("user login details match value : " + users.contains(userAuthObj));

    return isValid;
  }

  public static Optional<UserInfo> findUserInfo(final String username, final String password) {
    final UserInfo userInfo = new UserInfo(username, password);
    return users.stream().filter((user) -> user.equals(userInfo))
            .findFirst();
  }

}
