package com.kodecamp.student.db;

/**
 * This class represent the student.
 *
 * @author kcamp
 */
public final class Student {

  private final String rollNo;
  private final String name;
  private final String address;

  /**
   * primary constructor.
   *
   * @param rollNo rollnumber
   * @param name name
   * @param address address
   */
  public Student(final String rollNo, final String name, final String address) {
    this.rollNo = rollNo;
    this.name = name;
    this.address = address;
  }

  /**
   * secondary constructor.
   *
   * @param rollNo rollnumber
   */
  public Student(final String rollNo) {
    this(rollNo, "", "");
  }

  public String getRollNo() {
    return rollNo;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

}
