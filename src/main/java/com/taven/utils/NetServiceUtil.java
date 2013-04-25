package com.taven.utils;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NetServiceUtil {

	private static Log log = LogFactory.getLog(NetServiceUtil.class);

	public boolean checkServiceStatus(String serverIp, int serverPort) {

		Socket client = new Socket();
		try {
			//Socket client = new Socket(serverIp, Integer.parseInt(serverPort));
			//client.setSoTimeout(1000);

			InetAddress addr = Inet4Address.getByName(serverIp);
			client.connect(new InetSocketAddress(addr, serverPort), 200);

			return client.isConnected();

		}
		catch (UnknownHostException e) {

			log.error("UnknownHostException：" + e.getMessage() + " 服务器地址：" + serverIp + " 端口：" + serverPort);
		}
		catch (IOException e) {
			log.error("IOException：" + e.getMessage() + " 服务器地址：" + serverIp + " 端口：" + serverPort);
		}
		finally {
			try {
				client.close();
			}
			catch (IOException e) {
				log.debug("IOException：" + e.getMessage() + " 服务器地址：" + serverIp + " 端口：" + serverPort);
			}
		}

		return false;

	}

}
