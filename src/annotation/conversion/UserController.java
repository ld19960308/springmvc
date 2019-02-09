package annotation.conversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import annotation.format.Annotation;


@Controller
@RequestMapping(value="/conversion")
public class UserController {
	private static final Log logger=LogFactory.getLog(UserController.class);
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@ModelAttribute User user,Model model){
		logger.info(user);
		//model.addAttribute("user",user);
		return "conversion/regedit_success";
	}
	@RequestMapping(value="dataTrans",method=RequestMethod.POST)
	public String dataTrans(@ModelAttribute Annotation a,Model model){
		model.addAttribute("a",a);
		return "conversion/anno_success";
	}
	/*@ModelAttribute
	public void tran(String name,String birthday,Model model){
		User u=new User();
		u.setName(name);
		SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");
		try {
			u.setBirthday(dateFormat.parse(birthday));
		} catch (ParseException e){
			e.printStackTrace();
		}
		model.addAttribute("user", u);
	}*/
	//注册局部自定义数据转换编辑器
	@InitBinder
	public void initBinder(WebDataBinder binder){
		logger.info("init AddressEditor");
		binder.registerCustomEditor(Address.class,new AddressEditor());
	}

}
