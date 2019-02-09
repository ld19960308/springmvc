package annotation.format;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

public class CarFormatter implements Formatter<Car> {

	@Override
	public String print(Car arg0, Locale arg1) {
		// TODO Auto-generated method stub
		return arg0.getName()+","+arg0.getId();
	}

	@Override
	public Car parse(String arg0, Locale arg1) throws ParseException {
		// TODO Auto-generated method stub
		Car car=null;
		String[] strs=arg0.split(",");
		System.out.println(strs[0]+","+strs[1]);
		if(strs.length==2){
			car=new Car();
			car.setId(Integer.parseInt(strs[0]));
			car.setName(strs[1]);
		}
		return car;
	}

}
