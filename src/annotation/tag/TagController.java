package annotation.tag;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class TagController {
	private static final Log logger=LogFactory.getLog(TagController.class);
	@RequestMapping(value="/tagTest",method=RequestMethod.GET)
	public String tagTest(Model mod){
		Person p=new Person("li","123",new String[]{"足球","篮球"},"男",1,"他是一个学生");
		mod.addAttribute("person", p);
		mod.addAttribute("sexList",new String[]{"男","女"});
		return "tagTest";
	}
	/*public ModelAndView tagTest(ModelAndView mod){
		Person p=new Person("li","123",new String[]{"足球","篮球"},"男",1,"他是一个学生");
		mod.addObject("person", p);
		return mod;
	}*/
	@InitBinder
	public void initBinder(DataBinder binder){
		binder.setValidator(new PersonValidator());
	}
	@RequestMapping(value="/{formName}")
	public String jump(@PathVariable String formName){
		return formName;
	}
    @RequestMapping(value="/regedit")
    public String register(@Validated Person p,Errors e,Model model){
    	model.addAttribute("person", p);
    	if(e.hasFieldErrors()){
    		return "regedit";
    	}
    	return "index";
    }
}
