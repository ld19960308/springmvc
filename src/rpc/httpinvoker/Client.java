package rpc.httpinvoker;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import rpc.hessian.RPCService;
import rpc.hessian.User;

public class Client {
	public static void main(String[] args){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("rpc/httpinvoker/bean.xml");
		RPCService service=(RPCService)ctx.getBean("rpcProxy");
		List<User> user=service.getAllUser();
		User u=user.get(0);
		System.out.println(u.getName());
		
	}

}
