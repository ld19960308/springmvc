package jaxWs;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rpc.hessian.RPCService;
import rpc.hessian.User;

@Component
@WebService(serviceName="jaxWsService")
public class Hello1Service {
	@Autowired
	RPCService rpcService;
	@WebMethod
	public List<User> getAllUser(){
		return rpcService.getAllUser();
	}

}
