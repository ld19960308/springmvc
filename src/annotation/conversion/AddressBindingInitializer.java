package annotation.conversion;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class AddressBindingInitializer implements WebBindingInitializer {
    private static final Log logger=LogFactory.getLog(AddressBindingInitializer.class);
	@Override
	public void initBinder(WebDataBinder arg0, WebRequest arg1) {
		// TODO Auto-generated method stub
		System.out.println("init global transfer");
		arg0.registerCustomEditor(Address.class, new AddressEditor());

	}

}
