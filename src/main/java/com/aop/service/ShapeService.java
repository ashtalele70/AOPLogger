package com.aop.service;

import com.aop.model.Circle;
import com.aop.model.Triangle;

public class ShapeService {

  public Circle getCircle() {
    return circle;
  }

  public void setCircle(Circle circle) {
    this.circle = circle;
  }

  private Circle circle;
  private Triangle triangle;
}
