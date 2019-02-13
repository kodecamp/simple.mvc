package com.kodecamp.college.db;

import java.io.Serializable;

/**
 * <p>
 * This is the entity class.
 * </p>
 *
 * @author kcamp
 */
public final class College implements Serializable {

  private static final long serialVersionUID = 1L;
  private String regNo;
  private String name;
  private String address;

  /**
   * <p>
   * constructor.
   * </p>
   *
   * @param regNo <tt>String</tt>
   */
  public College(final String regNo) {
    this.regNo = regNo;
    this.name = "";
    this.address = "";
  }

  /**
   * <p>
   * primary constructor.
   * </p>
   *
   * @param regNo registration no
   * @param name name
   * @param address address
   */
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

  public void setRegNo(final String regNo) {
    this.regNo = regNo;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public void setAddress(final String address) {
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
  public boolean equals(final Object obj) {
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
