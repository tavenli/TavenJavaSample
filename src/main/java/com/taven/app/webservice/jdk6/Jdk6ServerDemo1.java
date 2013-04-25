package com.taven.app.webservice.jdk6;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

/*
 * 
 * 不需要Web容器 在Java App中提供WebService服务（必须JDK1.6或以上）
 * JAX-WS RI 2.1.6 in JDK 6
 */
@WebService(targetNamespace = "http://www.TavenLi.com")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Jdk6ServerDemo1 {

	@WebMethod
	public String getServerTime()
	{
		//返回服务器时间的方法
		return new Date(System.currentTimeMillis()).toString();

	}

	public static void main(String[] args)
	{
		//可以做到不借助web容器（如GlassFish或者Tomcat）发布Web Service应用
		//访问：
		//http://localhost:8088/ServerDemo1
		//http://localhost:8088/ServerDemo1?wsdl
		Endpoint.publish("http://localhost:8088/ServerDemo1", new Jdk6ServerDemo1());
		//可以发布多个服务在同一个端口上
		Endpoint.publish("http://localhost:8088/ServerDemo2", new Jdk6ServerDemo1());

		//也可以生成客户端调用类
		//使用命令 wsimport -keep -p 包名 WSDL地址 如：
		//D:\>wsimport -keep -p com.TavenLi.www http://localhost:8088/ServerDemo1?wsdl

		/**
		 * 方式1：生成Java客户端调用类
		 * 
		 * 使用命令 wsimport -keep -p 包名 WSDL地址 如：
		 * D:\>wsimport -keep -p com.pilicat http://localhost:9001/TopApiProxyService?wsdl
		 * 
		 * 得到2个类，调用的例子
		 * TopApiProxyServiceService service = new TopApiProxyServiceService();
		 * TopApiProxyService topApiProxyService = service.getTopApiProxyServicePort();
		 * 
		 * topApiProxyService.getTradesSoldJson(SIKey, SISecret, "卖家昵称", "2013-03-06 00:00:00", "", 1, 100, "");
		 * 
		 */

		/**
		 * 方式2：4行代码直接调用
		 * 
		 * java.net.URL url = new java.net.URL("http://127.0.0.1/TopApiProxyService?wsdl"); 
			// 第一个参数是服务的命名空间 
			// 第二个参数是在WSDL发布的服务名  
			javax.xml.namespace.QName qname = new javax.xml.namespace.QName("http://www.pilicat.com","TopApiProxyServiceService");  
			// 创建服务  
			javax.xml.ws.Service service = javax.xml.ws.Service.create(url, qname);  
			// 提取端点接口，服务“端口”
			TopApiProxyService topApiProxyService = service.getPort(TopApiProxyService.class); 
			
			注：TopApiProxyService 是根据wsdl描述文档定义的一个接口类
			
		*/
		
		
	}

}
