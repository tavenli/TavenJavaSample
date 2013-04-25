package com.taven.app.javabase.exception;

/**
 * <pre>
 * 自定义 Runtime 异常
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-6-13
 *         </p>
 */
public class ExceptionDemo2 extends RuntimeException {

	public ExceptionDemo2() {}

	public ExceptionDemo2(String message) {
		super(message);
	}

}
