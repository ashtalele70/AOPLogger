package com.aop;

import com.aop.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
    ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
    shapeService.getCircle();
    System.out.println(shapeService.getCircle().getName());
  }
}
