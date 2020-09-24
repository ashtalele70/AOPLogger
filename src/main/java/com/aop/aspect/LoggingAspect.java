package com.aop.aspect;

import com.aop.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {

  /*
  Advice is called only for explicitly made calls
  not for something that is called from bean
   */
  @Before("allCircleMethods()")
  public void LoggingAdvice(JoinPoint joinPoint) {
    System.out.println("Advice run. Get Method called");
    System.out.println(joinPoint.getTarget());
    Circle circle = (Circle) joinPoint.getTarget();
  }

  //can be used for pre processing
  @Before("args(name)")
  public void stringArgumentMethods(String name) {
    System.out.println("Method works fine " + name);
  }

  /*
  @After Even if exception is throw from the target method
  then also after block is executed. Works like finally.
  To do only if the target method is successfully executed
  we can use @AfterReturning
   */
  @AfterReturning(pointcut = "args(name)", returning = "returnString")
  public void stringArgumentMethodsAfter(String name, String returnString) {
    System.out.println("Method works fine after " + name);
    System.out.println("Returned string " + returnString);
  }

  /*
  To handle after exception scenarios
  We can have multi exception handlers
  so we can decide that if an exception occurs what should be next actions
   */
  @AfterThrowing(pointcut = "args(name)", throwing = "ex")
  public void exceptionAdvice(String name, RuntimeException ex) {
    System.out.println("An exception has been thrown");
    System.out.println("An exception ocurred " + ex);
  }

  @Around("allGetters()")
  public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {

    Object object= null;
    try{
      //code to be executed before
      System.out.println("Before target executing");

      //target method is executed on this line
      object = proceedingJoinPoint.proceed();
      
      //code to be executed after
      System.out.println("After target executing");
    } catch(Throwable e) {
      System.out.println("After throwing");
    }
    System.out.println("Finally");

    return object;
  }

  //  @Before("allGetters()")
  //  public void LoggingSecondAdvice() {
  //    System.out.println("Advice second run. Get Method called");
  //  }

  @Pointcut("execution(* get*())")
  public void allGetters() {}

  //for all Circle class methods
  //  @Pointcut("execution(* * com.aop.model.Cirlce.*(..))")
  //  public void allCircleMethods() {}

  //valid
  //com.aop.model.*
  //com.aop.model..
  @Pointcut("within(com.aop.model.Circle)")
  public void allCircleMethods() {}
}
