package com.taven.app.webservice.springws;

import java.util.Date;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

/**
 * <pre>
 * 使用 Spring Web Services 的例子
 * http://www.springsource.org/spring-web-services
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-5-29
 *         </p>
 */
@Endpoint
public class SpringWSDemo1 {

	@PayloadRoot(namespace = "", localPart = "getServerTime")
	public String getServerTime()
	{
		//返回服务器时间的方法
		return new Date(System.currentTimeMillis()).toString();

	}

	public static void main(String[] args)
	{
		//貌似只能依赖Web容器发布服务，等找到方法再说
	}
}
