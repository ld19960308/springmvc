package annotation.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import annotation.validation.Login;

@Controller
@RequestMapping(value="/interceptor")
public class InterceptorController {
	@RequestMapping(value="/intercept",method=RequestMethod.POST)
	public ModelAndView login(
			                   @RequestParam("username")String username,
			                   @RequestParam("password")String password,
			                   ModelAndView mv,
			                   HttpSession session){
		mv.setViewName("/interceptor/loginForm");
		if(username!=null&&password!=null&username.equals("li")&&password.equals("li")){
			Login l=new Login();
			l.setUsername(username);
			l.setPassword(password);
			session.setAttribute("user",l);
			mv.setViewName("redirect:/interceptor/main");
		}
		return mv;
	}
	@RequestMapping(value="/main")
	public String main(Model model){
		List<Book> book_list=new ArrayList<>();
		book_list.add(new Book("数据结构","宋",78));
		book_list.add(new Book("计算机原理","王",81));
		book_list.add(new Book("Java","李",10));
		model.addAttribute("book_list",book_list);
		return "interceptor/main";
	}
	@RequestMapping(value="/{formname}")
	public String jump(@PathVariable String formname){
		return "/interceptor/"+formname;
	}

}
