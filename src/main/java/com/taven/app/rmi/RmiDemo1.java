package com.taven.app.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RmiDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//注册RMI服务，并启动RMI服务

		try {
			SimpleRmiService simpleRmiService = new SimpleRmiServiceImpl();

			//本地主机上的远程对象注册表Registry的实例，并指定端口为8888，这一步必不可少（Java默认端口是1099），必不可缺的一步，缺少注册表创建，则无法绑定对象到远程注册表上 
			LocateRegistry.createRegistry(8888);

			//把远程对象注册到RMI注册服务器上，并命名为RHello 
			//绑定的URL标准格式为：rmi://host:port/name(其中协议名可以省略，下面两种写法都是正确的） 
			Naming.bind("rmi://localhost:8888/Demo1", simpleRmiService);
			//Naming.bind("//localhost:8888/Demo1", simpleRmiService);

			System.out.println("Rmi服务已经启动.");

			//测试
			rmiClientTest();

		}
		catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void rmiClientTest() {

		try {
			SimpleRmiService simpleRmiService = (SimpleRmiService) Naming.lookup("rmi://localhost:8888/Demo1");
			System.out.println("Rmi默认方式取得的时间：" + simpleRmiService.getServerTime().toLocaleString());
		}
		catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
