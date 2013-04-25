package com.taven.app.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class SimpleRmiServiceImpl extends UnicastRemoteObject implements SimpleRmiService {

	/**
	 * 需要继承 UnicastRemoteObject 类，并提供一个强制的构造方法
	 * 
	 * @throws RemoteException
	 */
	public SimpleRmiServiceImpl() throws RemoteException {}

	public Date getServerTime() throws RemoteException {
		return new Date();
	}

}
