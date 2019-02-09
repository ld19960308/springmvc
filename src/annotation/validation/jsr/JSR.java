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
	@NotBlank(message="�û�������Ϊ��")
	private String loginname;
	@NotBlank(message="���벻��Ϊ��")
	@Length(min=6,max=8,message="������6-8֮��")
	private String password;
	@Range(min=15,max=60,message="������15��60֮��")
	private int age;
	@Email(message="�������")
	private String email;
	@DateTimeFormat(pattern="YYYY-MM-dd")
	@Past(message="���ձ�����֮ǰ��һ������")
	private Date birthday;
	@Pattern(regexp="[1][3,8][3,6,9][0-9]{8}",message="�绰��ʽ����")
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
