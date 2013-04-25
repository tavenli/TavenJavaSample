package com.taven.app.javabase.reflect.model;

public class Person {

	private String name;

	public void sayHello()
	{
		System.out.println("hello");
	}

	public String sayHello(String yourName)
	{
		this.setName("Big Person");
		String result = yourName + ",my name is " + this.name;
		System.out.println(result);
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
