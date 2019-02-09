package annotation.format;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class Annotation {
	@DateTimeFormat(pattern="YYYY-MM-dd")
	private Date birthday;
	@NumberFormat(style=Style.NUMBER,pattern="#,###")
	private int total;
	@NumberFormat(style=Style.PERCENT)
	private double discount;
	@NumberFormat(style=Style.CURRENCY)
	private double money;
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}

}
