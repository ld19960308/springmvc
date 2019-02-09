package li;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
	private String username;
	private String password;
	private boolean sex;
    private String address;
    public User(){}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    public boolean findUser(){
    	Statement sta=DBConnection.getStatement();
    	if(sta==null){
    		//throw new Exception("fail to get statement");
    		return false;
    	}
    	String sql="select * from user where username='"+username+"' and password='"+password+"'";
    	try {
			ResultSet rs=sta.executeQuery(sql);
			while(rs.next()){
				//sex=rs.getByte(3)==1?true:false;
				//address=rs.getString(4);
				return true;	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return false;
    }
}
