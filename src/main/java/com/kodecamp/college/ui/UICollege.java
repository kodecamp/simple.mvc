/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kodecamp.college.ui;

import com.kodecamp.college.db.College;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author kcamp
 */
public class UICollege implements Serializable {

  private static final long serialVersionUID = 1L;

  private final College college;
  private String deleteUrl;
  private String updateUrl;
  private static String DELETE_URL = "/college/delete.xhtml?regNo=%s";
  private static String UPDATE_URL = "/college/updateform.xhtml?regNo=%s";

  public UICollege(final College college, final String contextPath) {
    this.college = college;
    this.deleteUrl = String.format(contextPath + DELETE_URL, college.getRegNo());
    this.updateUrl = String.format(contextPath + UPDATE_URL, this.college.getRegNo());
  }

  public College getCollege() {
    return college;
  }

  public String getDeleteUrl() {
    return this.deleteUrl;
  }

  public String getUpdateUrl() {
    return this.updateUrl;
  }

  public void setDeleteUrl(String deleteUrl) {
    this.deleteUrl = deleteUrl;
  }

  public void setUpdateUrl(String updateUrl) {
    this.updateUrl = updateUrl;
  }


  @Override
  public int hashCode() {
    int hash = 7;
    return hash;
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
    final UICollege other = (UICollege) obj;
    if (!Objects.equals(this.college, other.college)) {
      return false;
    }
    return true;
  }


}
