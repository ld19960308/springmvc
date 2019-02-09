package jaxWs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import rpc.hessian.RPCService;

public class Client {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("jaxWs/bean.xml");
		RPCService rpcService=(RPCService)ctx.getBean("rmiProxy");
		System.out.println(rpcService.getAllUser().get(0).getName());

	}

}
