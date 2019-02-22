/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kodecamp.college.db;

/**
 * This file is entity class.
 *
 * @author kcamp
 */
public class CollegeEntity {

  private String name;
  private String address;

  public CollegeEntity(String name, String address) {
    this.name = name;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

}
