package annotation.conversion;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {
	private static final Log logger=LogFactory.getLog(StringToDateConverter.class);
    private String datePattern;
	public String getDatePattern() {
		return datePattern;
	}
	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
	@Override
	public Date convert(String arg0) {
		// TODO Auto-generated method stub
		try{
			SimpleDateFormat dateFormat=new SimpleDateFormat(this.getDatePattern());
			return dateFormat.parse(arg0);
		}catch(Exception e){
			e.printStackTrace();
			logger.info("日期转化失败");
			return null;
		}
	}

}
