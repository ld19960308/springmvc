package jaxWs;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import rpc.hessian.RPCService;
import rpc.hessian.User;
//@WebService(serviceName="helloService")
public class HelloService extends SpringBeanAutowiringSupport {
	@Autowired
	RPCService rpcService;
	@WebMethod
	public List<User> getAllUser(){
		return rpcService.getAllUser();
	}

}
