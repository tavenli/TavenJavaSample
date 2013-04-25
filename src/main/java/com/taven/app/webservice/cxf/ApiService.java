package com.taven.app.webservice.cxf;

import javax.jws.WebService;

@WebService
public interface ApiService {

	public abstract String sayHello(String yourName);

}