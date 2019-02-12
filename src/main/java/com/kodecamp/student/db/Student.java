package com.kodecamp.student.db;

/**
 *
 * @author kcamp
 */
public class Student {
  private String rollNo;
  private String name;
  private String address;
  
  public Student(final String rollNo, final String name, final String address) {
    this.rollNo = rollNo;
    this.name = name;
    this.address = address;
  }

  public Student(String rollNo) {
    this.rollNo = rollNo;
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
