package com.taven.app.webservice.cxf;


public class ApiServiceImpl implements ApiService {

	/* (non-Javadoc)
	 * @see com.taven.app.webservice.ApiService#sayHello(java.lang.String)
	 */
	public String sayHello(String yourName) {
		return "Hi," + yourName;
	}
}
