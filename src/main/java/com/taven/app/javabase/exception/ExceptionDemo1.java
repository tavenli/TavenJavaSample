package com.taven.app.javabase.exception;

/**
 * <pre>
 * 自定义一个 Checked 异常
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-6-13
 *         </p>
 */
public class ExceptionDemo1 extends Exception {

	public ExceptionDemo1() {}

	public ExceptionDemo1(String message) {
		super(message);
	}

	public ExceptionDemo1(Exception ex) {
		//调用父类的 Exception(Throwable cause)
		//cause 参数表示一个原始异常
		super(ex);
	}

	public ExceptionDemo1(String message, Exception ex) {
		//调用父类的 Exception(String message, Throwable cause)
		//cause 参数表示一个原始异常
		super(message, ex);

	}

}
