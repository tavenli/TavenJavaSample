package com.taven.app.javabase.annotation;

@PersistentAnnotation(table = "user_inf")
public class AnnotationDemo1 {

	@PropertyAnnotation(column = "user_name", type = "string")
	private String name;
	@PropertyAnnotation(column = "user_age", type = "integer")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
