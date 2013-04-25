package com.taven.app.rmi.spring;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.taven.utils.RmiFactory;

/**
 * <pre>
 * 调用RMI的Demo
 * 该例子使用Spring发布RMI服务
 * 相关配置在 applicationContext-app.xml 中
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-5-16
 *         </p>
 */
public class RmiClient {

	private static Log log = LogFactory.getLog(RmiClient.class);

	public static void main(String[] args) {
		//调用RMI的客户端
		ServerTimeService serverTimeService = RmiFactory.getInstance().getRmiService(ServerTimeService.class, "127.0.0.1", "9100", "serverTimeService");
		Date date = serverTimeService.getServerTime();

		log.info(date.toString());

	}
}
