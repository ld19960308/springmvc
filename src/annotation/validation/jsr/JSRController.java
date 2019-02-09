package annotation.validation.jsr;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/validation/jsr")
public class JSRController {
	@RequestMapping(value="/{formName}")
	public String jump(@PathVariable String formName,Model model){
		JSR jsr=new JSR();
		model.addAttribute("jsr",jsr);
		return "validation/jsr/"+formName;
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(
			@Valid @ModelAttribute JSR jsr,
			Errors errors,
			Model model){
		System.out.println(jsr);
		System.out.println(errors.getFieldErrorCount());
		if(errors.hasErrors()){
			return "validation/jsr/registerForm";
		}
		model.addAttribute("jsr",jsr);
		return "validation/jsr/success";
	}

}
