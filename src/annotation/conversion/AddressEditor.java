package annotation.conversion;

import java.beans.PropertyEditorSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AddressEditor extends PropertyEditorSupport {
	private static final Log logger=LogFactory.getLog(AddressEditor.class);

	@Override
	public void setAsText(String arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Address a=new Address();
		String[] args=arg0.split(",");
		System.out.println(args[0]+","+args[1]);
		if(args.length==2){
			a.setCountry(args[0]);
			a.setCity(args[1]);
		}
		setValue(a);
	}
	

}
