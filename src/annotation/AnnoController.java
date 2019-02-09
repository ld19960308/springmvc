package annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.portlet.ModelAndView;

@Controller
@SessionAttributes(value={"name","password"})
@RequestMapping(value="/anno")
public class AnnoController {
	private static final Log logger=LogFactory.getLog(AnnoController.class);
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public ModelAndView hello(@RequestParam("password")String password,ModelAndView mod,Model model){
	//public ModelAndView hello(@ModelAttribute("password")String password,ModelAndView mod){
		/*String name=(String)model.asMap().get("name");
		String age=(String)model.asMap().get("age");*/
		String name="123";
		String age=(String)mod.getModel().get("age");
		//model.addAttribute("name", name);
		logger.info("name:"+name);
		logger.info("ModelAndViewµÄmodel:"+mod.getModel());
		logger.info("Model:"+model);
		/*mod.addObject("age",age);
		password="147";
		mod.addObject("password",password);
		//model.addAttribute("password", password);
		mod.setViewName("hello_success");*/
		return mod;
	}
	@ModelAttribute
    public void nameModel(String name,String age,Model mod){
		logger.info("ModelAttribute");
    	mod.addAttribute("name", name);
    	if(age==null) age="age=null";
    	mod.addAttribute("age",age);
    	logger.info("name:"+name);
    	logger.info("age:"+age);
    }
	@RequestMapping(value="/pathVariable/{id}",method=RequestMethod.GET)
	public String pathVariable(@PathVariable Integer id){
		logger.info("pathVariableTest:"+id);
		return "index";
	}
	@RequestMapping(value="/requestHeader")
	public void requestHeader(@RequestHeader("User-Agent")String agent,
	                           @RequestHeader(value="Accept")String[] accepts){
	        for(String a:accepts){
	        	logger.info(a);
	        }
	}
	@RequestMapping(value="/cookieValue")
	public void cookieValue(@CookieValue(value="JSESSIONID",defaultValue="")String id){
		logger.info("session id:"+id);
	}
} 
