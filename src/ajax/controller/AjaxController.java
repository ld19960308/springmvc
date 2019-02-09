package ajax.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/ajax")
public class AjaxController {
	@RequestMapping(value="/aw")
	public void aw(HttpServletResponse response){
		System.out.println("aw start");
		try {
			response.getWriter().write("hello world");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/test")
	public void test(HttpServletResponse response,HttpServletRequest request){
		System.out.println("test stat");
		try {
			response.getWriter().write("name='li'");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*@RequestMapping(value="/{formName}")
	public String jump(@PathVariable String formName){
		return "ajax/"+formName;
	}*/

}
