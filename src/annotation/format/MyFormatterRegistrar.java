package annotation.format;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

import annotation.conversion.StringToDateConverter;

public class MyFormatterRegistrar implements FormatterRegistrar {
    private CarFormatter formatter;
    private StringToDateConverter converter;
	public StringToDateConverter getConverter() {
		return converter;
	}
	public void setConverter(StringToDateConverter converter) {
		this.converter = converter;
	}
	public CarFormatter getFormatter() {
		return formatter;
	}
	public void setFormatter(CarFormatter formatter) {
		this.formatter = formatter;
	}
	@Override
	public void registerFormatters(FormatterRegistry arg0) {
		// TODO Auto-generated method stub
        arg0.addFormatter(getFormatter());
        arg0.addConverter(converter);
	}

}
