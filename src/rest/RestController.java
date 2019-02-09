package rest;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import rpc.hessian.User;

@Controller
@RequestMapping("/rest")
public class RestController {
	@RequestMapping(value="/{username}",method=RequestMethod.GET,headers={"Accept=text/html,application/json"})
	public @ResponseBody User[] getUser(@PathVariable String username){
		User[] u=null;
		User s=new User();
		s.setName(username);
		u=new User[]{ s };
		return u;
		
	}
	@RequestMapping(value="/{id}/user",method=RequestMethod.PUT,headers="Content-Type=application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void putUser(@PathVariable String id,@RequestBody User u){
		System.out.println("客户端传来的id:"+id+",姓名:"+u.getName());
		
	}
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable String id){
		System.out.println("客户端传来的要删除用户id:"+id);
		
	}
	/*@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody User saveUser(@Valid User u,BindingResult result,HttpServletResponse response){	
		return u;
	}*/
	@RequestMapping(value="/user",method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody User saveUser(@RequestBody User u){	
		System.out.println("post方法");
		return u;
	}

}
