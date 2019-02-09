package annotation.tag;

public class Person {
	private String name;
	private String password;
	private String[] hobby;
	private String sex;
	private int classid;
	private String desc;
	public Person(){}
	public Person(String name, String password, String[] hobby, String sex, int classid, String desc) {
		super();
		this.name = name;
		this.password = password;
		this.hobby = hobby;
		this.sex = sex;
		this.classid = classid;
		this.desc = desc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
