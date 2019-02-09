package demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloWorldController { 
 @RequestMapping("/hello")
 public String helloWorld() { 
  //String message = "Hello World, Spring 3.0!";
  //System.out.println(message);
 //  return new ModelAndView("hello", "message", message);
  return "hello";
 } 
}