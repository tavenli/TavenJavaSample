package com.taven.app.javabase.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public class SocketMain {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		/**
		 * 
		 * IP V4 被分成了A、B、C、D、E五类
		 * 
		 * A类：10.0.0.0 ~ 10.255.255.255
		 * B类：172.16.0.0 ~ 172.31.255.255
		 * C类：192.168.0.0 ~ 192.168.255.255
		 * D类：224.0.0.0 ~ 239. 255. 255.254
		 * E类：240.0.0.0 ~ 255.255.255.255 （E 类地址保留作研究之用，因此Internet上没有可用的E类地址）
		 * 
		 * 端口号范围：0 ~ 65535
		 * 
		 * 公认端口（Well Known Ports）：0~1023
		 * 紧密绑定一些特定的服务
		 * 
		 * 注册端口（Registered Ports）：1024~49151
		 * 松散地绑定一些服务，应用程序应该使用这个范围内的端口
		 * 
		 * 动听和/或私有端口（Dynamic and/or Private Ports）：49152~65535
		 * 应用程序使用的动态端口，应用程序一般不会主动使用这些端口
		 * 
		 * 
		 */

		// 根据主机名来获取对应的InetAddress实例
		InetAddress ip = InetAddress.getByName("www.crazyit.org");
		// 判断是否可达
		System.out.println("crazyit是否可达：" + ip.isReachable(2000));
		// 获取该InetAddress实例的IP字符串
		System.out.println(ip.getHostAddress());
		// 根据原始IP地址来获取对应的InetAddress实例
		InetAddress local = InetAddress.getByAddress(
				new byte[] { 127, 0, 0, 1 });
		System.out.println("本机是否可达：" + local.isReachable(5000));
		// 获取该InetAddress实例对应的全限定域名
		System.out.println(local.getCanonicalHostName());

		/**
		 * 
		 * 
		 */

		// 将application/x-www-form-urlencoded字符串
		// 转换成普通字符串
		// 其中的字符串直接从图17.3所示窗口复制过来
		String keyWord = URLDecoder.decode(
				"%B7%E8%BF%F1java", "GBK");
		System.out.println(keyWord);
		// 将普通字符串转换成
		// application/x-www-form-urlencoded字符串
		String urlStr = URLEncoder.encode(
				"疯狂Android讲义", "GBK");
		System.out.println(urlStr);

		/**
		 * 
		 * 
		 */

		// 发送GET请求
		String s = sendGet("http://localhost:8888/abc/a.jsp"
				, null);
		System.out.println(s);
		// 发送POST请求
		String s1 = sendPost("http://localhost:8888/abc/login.jsp"
				, "name=crazyit.org&pass=leegang");
		System.out.println(s1);

	}

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，格式满足name1=value1&name2=value2的形式。
	 * @return URL所代表远程资源的响应
	 */
	public static String sendGet(String url, String param)
	{
		String result = "";
		String urlName = url + "?" + param;
		try
		{
			URL realUrl = new URL(urlName);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent"
					, "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 建立实际的连接
			conn.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = conn.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet())
			{
				System.out.println(key + "--->" + map.get(key));
			}
			try
			{
				// 定义BufferedReader输入流来读取URL的响应
				BufferedReader in = new BufferedReader(
						new InputStreamReader(conn.getInputStream(), "utf-8"));

				String line;
				while ((line = in.readLine()) != null)
				{
					result += "\n" + line;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch (Exception e)
		{
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 向指定URL发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，格式应该满足name1=value1&name2=value2的形式。
	 * @return URL所代表远程资源的响应
	 */
	public static String sendPost(String url, String param)
	{
		String result = "";
		try
		{
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			try
			{
				// 获取URLConnection对象对应的输出流
				PrintWriter out = new PrintWriter(conn.getOutputStream());

				// 发送请求参数
				out.print(param);
				// flush输出流的缓冲
				out.flush();
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			try
			{
				// 定义BufferedReader输入流来读取URL的响应
				BufferedReader in = new BufferedReader(new InputStreamReader
						(conn.getInputStream(), "utf-8"));

				String line;
				while ((line = in.readLine()) != null)
				{
					result += "\n" + line;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch (Exception e)
		{
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
		}
		return result;
	}
}
