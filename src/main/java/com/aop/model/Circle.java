package com.aop.model;

public class Circle {

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
    System.out.println("Circle's setter has been called");
    throw(new RuntimeException());
  }

  public String setNameReturn(String name) {
    this.name = name;
    System.out.println("Set name return called");
    return name;
  }
  private String name;
}
