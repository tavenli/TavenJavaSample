package com.taven.app.rmi.spring;

import java.util.Date;

public class ServerTimeServiceImpl implements ServerTimeService {

	/* (non-Javadoc)
	 * @see com.taven.app.rmi.ServerTimeService#getServerTime()
	 */
	public Date getServerTime() {
		return new Date();
	}

}
