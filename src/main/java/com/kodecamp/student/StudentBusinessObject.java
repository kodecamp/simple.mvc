package com.kodecamp.student;

import com.kodecamp.student.db.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kcamp
 */
public class StudentBusinessObject {

  public List<Student> fetchAll() {
    List<Student> students = new ArrayList<>();
    students.add(new Student("1", "Sunil", "Naini"));
    students.add(new Student("2", "Sushil", "Lucknow"));
    students.add(new Student("3", "Rakesh", "Delhi"));
    return students;
  }
}
