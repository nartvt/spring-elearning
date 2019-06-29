package com.elearning.program.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(NoHandlerFoundException.class)
  public String notFound404() {
    return "error404";

  }
  @ExceptionHandler(Exception.class)
  public String notFound500() {
    return "error500";

  }
  {

  }
}
