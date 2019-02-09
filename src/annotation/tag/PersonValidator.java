package annotation.tag;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {
    private static final Log logger=LogFactory.getLog(PersonValidator.class);
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		logger.info("校验器中的support方法");
		return Person.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		logger.info("校验器的校验函数");
        ValidationUtils.rejectIfEmpty(arg1,"name", null,"用户名不能为空");
	}

}
