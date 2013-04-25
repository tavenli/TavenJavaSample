package com.taven.app.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * <pre>
 * 默认方式发布RMI
 * 必须继承 Remote 接口，所有方法必须抛出 RemoteException
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-5-27
 *         </p>
 */
public interface SimpleRmiService extends Remote {

	public abstract Date getServerTime() throws RemoteException;

}
