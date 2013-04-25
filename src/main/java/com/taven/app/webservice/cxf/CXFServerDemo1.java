package com.taven.app.webservice.cxf;

/*
 * import javax.xml.ws.Endpoint;
 * import org.apache.cxf.interceptor.LoggingInInterceptor;
 * import org.apache.cxf.interceptor.LoggingOutInterceptor;
 * import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
 */

/**
 * <pre>
 * Apache CXF
 * http://cxf.apache.org
 * Apache CXF = Celtix + XFire，Apache CXF 的前身叫 Apache CeltiXfire
 * 现在已经正式更名为 Apache CXF 了，简称为 CXF
 * CXF 继承了 Celtix 和 XFire 两大开源项目的精华
 * 
 * Maven引用 org.apache.cxf 2.6的pom所有包
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-5-14
 *         </p>
 */
public class CXFServerDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//发布WebService方式1：
		/*JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		factory.setAddress("http://localhost:9999/helloService");
		factory.setServiceClass(ApiServiceImpl.class);
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.create();*/

		//发布WebService方式2：
		//Endpoint.publish("http://127.0.01:9999/myService", new ApiServiceImpl());

	}

}
