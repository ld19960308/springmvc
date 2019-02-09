package annotation.validation;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/validation")
public class ValidationController {
	@Autowired
	@Qualifier("loginValidator")
	private LoginValidator loginValidator;
	@RequestMapping(value="/login")
    public String login(@ModelAttribute Login login,Model model,Errors e){
		
		  loginValidator.validate(login, e);
		  System.out.println(e.getFieldError("username").getDefaultMessage());
		  System.out.println(e.getFieldError("password").getDefaultMessage());
		  model.addAttribute("error",e.getFieldError("username").getDefaultMessage());
		  model.addAttribute("login",login);
		  if(e.hasErrors()){
				return "validation/loginForm";
			}
		
		return "validation/login_success";
	}
	@RequestMapping("/{formName}")
	public String jump(@PathVariable String formName,Model model){
		Login l=new Login();
		model.addAttribute("login",l);
		return "validation/"+formName;
	}
}
