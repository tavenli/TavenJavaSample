package com.taven.utils;

import java.io.IOException;
import java.net.Socket;
import java.rmi.server.RMIClientSocketFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

public class RmiFactory {
	private static Log log = LogFactory.getLog(RmiFactory.class);

	private static RmiFactory instance;

	private RmiFactory() {

	}

	public static RmiFactory getInstance() {
		if (instance == null) {
			return new RmiFactory();
		}
		else {
			return instance;
		}
	}

	/**
	 * 使用Spring代理方式的RMI客户端
	 * 
	 * @param service
	 * @param ip
	 * @param port
	 * @param serviceName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getRmiService(Class<T> service, String ip, String port, String serviceName) {

		try {
			RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
			String rmiUrl = "rmi://" + ip + ":" + port + "/" + serviceName;
			rmiProxy.setServiceUrl(rmiUrl);
			//设置超时时间
			rmiProxy.setRegistryClientSocketFactory(new RMICustomClientSocketFactory(2000));

			rmiProxy.setServiceInterface(service);
			rmiProxy.afterPropertiesSet();

			return (T) rmiProxy.getObject();
		}
		catch (Exception e) {
			log.error("Rmi服务异常 " + e.getMessage());

		}
		return null;

	}

	public class RMICustomClientSocketFactory implements RMIClientSocketFactory {

		/**
		 * 设置超时时间
		 */
		private int timeout;

		public RMICustomClientSocketFactory(int timeout) {
			this.timeout = timeout;
		}

		public Socket createSocket(String host, int port) throws IOException {
			Socket socket = new Socket(host, port);
			socket.setSoTimeout(timeout);
			return socket;
		}

	}
}
