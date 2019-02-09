package li;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConnection {
	private static User user=null;
	private static Connection con=null;
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://127.0.0.1:3306/login_and_regedit";
	private static String username="root";
	private static String password="141203121";
	/*private static String driver=null;
	private static String url=null;
	private static String username=null;
	private static String password=null;*/
	//private static String configFile="E:\\Tomcat 8.0\\webapps\\springmvc\\WEB-INF\\classes\\li\\my.properties";
	private static String configFile="my.properties";
	private DBConnection(){
		loadFile(configFile);
	}
	private static void createConnection(){
		try {
			if(driver==null||url==null||username==null||password!=null){
				loadFile(configFile);
			}
			  Class.forName(driver);
			  con=DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
         catch (SQLException e) {
			e.printStackTrace();
		}		
	}
    private static void loadFile(String configFile){
    	Properties props=new Properties();
    	try {
    		File file=new File(".");
        	System.out.println(file.getAbsolutePath());
			props.load(new FileInputStream(configFile));
			driver=props.getProperty("driver");
			url=props.getProperty("url");
			username=props.getProperty("username");
			password=props.getProperty("password");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public DBConnection getInstance(){
    	return this;
    }
    public static Statement getStatement(){
    	if(con==null){
    		createConnection();
    	}
    	try {
			return con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
}
