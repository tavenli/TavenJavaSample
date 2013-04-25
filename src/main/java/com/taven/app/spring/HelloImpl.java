package com.taven.app.spring;

import org.springframework.stereotype.Service;

@Service
public class HelloImpl implements Hello {

	/* (non-Javadoc)
	 * @see com.taven.app.spring.Hello#sayHello()
	 */
	public String sayHello() {
		return "Hello,Taven!";
	}
}
