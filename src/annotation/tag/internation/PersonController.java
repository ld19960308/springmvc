package annotation.tag.internation;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import annotation.tag.Person;

@Controller
@RequestMapping(value="/internation")
public class PersonController {
	private static final Log logger=LogFactory.getLog(PersonController.class);
	@RequestMapping(value="/login")
	public String login(Model model,HttpServletRequest request){
		RequestContext requestContext=new RequestContext(request);
		Person p=(Person)model.asMap().get("person");
		String name=requestContext.getMessage("name");
		System.out.println(name);
		if(p.getName()==null){
			return "internation/login";
		}
		//p.setName(name);
		return "internation/login_success";
	}
	@RequestMapping(value="/login_session")
	public String login_session(String request_locale,Model model,HttpServletRequest request){
		if(request_locale!=null){
			if(request_locale.equals("zh_CN")){
				Locale l=new Locale("zh","CN");
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, l);
			}
			else if(request_locale.equals("en_US")){
				Locale l=new Locale("en","US");
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, l);
			}
			else{
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, LocaleContextHolder.getLocale());
			}
		}
		if(((Person)(model.asMap().get("person"))).getName()==null)  return "internation/login_session";
		else return "internation/login_success";
	}
	@RequestMapping(value="/login_cookie")
	public String login_cookie(String request_locale,Model model,HttpServletRequest request,HttpServletResponse response){
		if(request_locale!=null){
			if(request_locale.equals("zh_CN")){
				Locale l=new Locale("zh","CN");
				(new CookieLocaleResolver()).setLocale(request,response,l);
			}
			else if(request_locale.equals("en_US")){
				Locale l=new Locale("en","US");
				(new CookieLocaleResolver()).setLocale(request,response,l);
			}
			else{
				(new CookieLocaleResolver()).setLocale(request,response,LocaleContextHolder.getLocale());
			}
		}
		if(((Person)(model.asMap().get("person"))).getName()==null)  return "internation/login_cookie";
		else return "internation/login_success";
	}
	@ModelAttribute
	public void tranToPerson(String name, String password,Model model){
		Person p=new Person();
		p.setName(name);
		p.setPassword(password);
		model.addAttribute("person",p);
		logger.info("tranToPerson start");
		logger.info(name);
		logger.info("tranToPerson end");
		
	}

}
