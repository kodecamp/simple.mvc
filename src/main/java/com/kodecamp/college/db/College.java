package com.kodecamp.college.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class College implements Serializable {

  private static final long serialVersionUID = 1L;
  private String regNo;
  private String name;
  private String address;

  public College(final String regNo) {
    this.regNo = regNo;
    this.name = "";
    this.address = "";
  }

  public College(final String regNo, final String name, final String address) {
    this.regNo = regNo;
    this.name = name;
    this.address = address;
  }

  public String getRegNo() {
    return regNo;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public void setRegNo(String regNo) {
    this.regNo = regNo;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((regNo == null) ? 0 : regNo.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    College other = (College) obj;
    if (regNo == null) {
      if (other.regNo != null) {
        return false;
      }
    } else if (!regNo.equals(other.regNo)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "College [regNo=" + regNo + ", name=" + name + ", address=" + address + "]";
  }

}
