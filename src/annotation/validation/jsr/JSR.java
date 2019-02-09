package annotation.validation.jsr;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class JSR {
	@NotBlank(message="用户名不能为空")
	private String loginname;
	@NotBlank(message="密码不能为空")
	@Length(min=6,max=8,message="长度在6-8之间")
	private String password;
	@Range(min=15,max=60,message="年龄在15到60之间")
	private int age;
	@Email(message="邮箱错误")
	private String email;
	@DateTimeFormat(pattern="YYYY-MM-dd")
	@Past(message="生日必须是之前的一个日期")
	private Date birthday;
	@Pattern(regexp="[1][3,8][3,6,9][0-9]{8}",message="电话格式错误")
	private String phone;
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "JSR [loginname=" + loginname + ", password=" + password + ", age=" + age + ", email=" + email
				+ ", birthday=" + birthday + ", phone=" + phone + "]";
	}
}
