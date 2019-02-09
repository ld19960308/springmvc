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
		logger.info("У�����е�support����");
		return Person.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		logger.info("У������У�麯��");
        ValidationUtils.rejectIfEmpty(arg1,"name", null,"�û�������Ϊ��");
	}

}
