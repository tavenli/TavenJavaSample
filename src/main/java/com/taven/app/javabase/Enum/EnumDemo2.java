package com.taven.app.javabase.Enum;

public enum EnumDemo2 {

	/**
	 * 第一
	 */
	First,
	/**
	 * 第二
	 */
	Second,
	/**
	 * 第三
	 */
	Third;

	/**
	 * 枚举中包含方法
	 * 
	 * @param input
	 * @return
	 */
	public static EnumDemo2 convert(String input) {

		if (input.equals("First")) {
			return EnumDemo2.First;
		}
		else {
			return Third;
		}

	}
}
