package li;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.simple.SimpleLogger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	@RequestMapping(value="/findUser",method=RequestMethod.POST)
	public String findUser(@RequestParam("username")String username,@RequestParam("password")String password,Model model){
		//System.out.println("username:"+username+",password:"+password);
		Logger logger=LogManager.getRootLogger();
		logger.info("username:"+username+",password:"+password);
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		//model.addAttribute(user);
		if(user.findUser()){
		    return "login_success";
		}
		else{
			return "index";
		}
	}

}
