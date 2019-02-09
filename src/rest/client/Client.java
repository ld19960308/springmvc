package rest.client;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import rpc.hessian.User;

/**
 * 依赖的包为jackson-core-asl和jackson-mapper-asl
 *
 *
 */
public class Client {
	private RestTemplate restTemplate;
	{
	   restTemplate=new RestTemplate();	
	}
	public static void main(String[] args){
	   Client client=new Client();
	   /*User[] u=client.retrieveUser("li");
	   if(u!=null){
		     for(User a:u){
			   System.out.println(a.getName());
		     }
		   }else{
			   System.out.println("出错");
		   }
	   System.out.println("********************************");
	   User[] us=client.retrieveUserForEntry("song");
	   if(us!=null){
	     for(User a:us){
		   System.out.println(a.getName());
	     }
	   }else{
		   System.out.println("出错");
	   }
	   client.updateUser();
	   client.deleteUser();*/
	   User user=client.saveUser();
	   System.out.println("保存的对象id:"+user.getId());
	}
	public User[] retrieveUser(String username){
	    User[] u=null;
	    u=restTemplate.getForObject("http://localhost:8080/springmvc/rest/{username}", User[].class,username);
		return u;
	}
	public User[] retrieveUserForEntry(String username){
		ResponseEntity<User[]> r=(ResponseEntity<User[]>) restTemplate.getForEntity("http://localhost:8080/springmvc/rest/{username}", User[].class,username);
		if(r.getStatusCode()==HttpStatus.NOT_MODIFIED){
			return null;
		}
		return r.getBody();
	}
	public void updateUser() {
		User user=new User();
		user.setId(1);
		user.setName("li");
		String url="http://localhost:8080/springmvc/rest/"+user.getId()+"/user";
		try {
			restTemplate.put(new URI(url), user);
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	public void deleteUser(){
		try{
			restTemplate.delete(new URI("http://localhost:8080/springmvc/rest/4"));
		}catch(URISyntaxException e){
			e.printStackTrace();
		}
	}
	public User saveUser(){
		User user=new User();
		user.setId(13);
		user.setName("li");
		return restTemplate.postForObject("http://localhost:8080/springmvc/rest/user", user, User.class);
	}

}
