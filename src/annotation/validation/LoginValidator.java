package annotation.validation;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Repository("loginValidator")
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Login.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(arg1, "username",null, "用户名不能为空");
		ValidationUtils.rejectIfEmpty(arg1, "password",null,"密码不能为空");
		Login l=(Login)arg0;
		if(l.getUsername().length()>5&&
		   l.getUsername()!=null&&
		    !l.getUsername().equals("")){
			arg1.rejectValue("username",null,"用户名长度过长");
		}
		if(l.getPassword()!=null&&
		   !l.getPassword().equals("")&&
		   l.getPassword().length()>5){
			arg1.rejectValue("password",null, "密码过长");
		}
		List<FieldError> list=arg1.getFieldErrors();
		Iterator iter=list.iterator();
		while(iter.hasNext()){
			FieldError error=(FieldError)iter.next();
			System.out.println(error);
		}

	}

}
