package rpc.hessian;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.rmi.RmiServiceExporter;

public class Server {
	public static void main(String[] args) throws InterruptedException, RemoteException{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("rpc/Server.xml");
		System.out.println("�����ļ����سɹ�");
		RmiServiceExporter rmiServiceExporter=(RmiServiceExporter)ctx.getBean("rmiServiceExporter");
		rmiServiceExporter.destroy();
	}

}
