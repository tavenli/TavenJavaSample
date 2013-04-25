package com.taven.app.javabase.reflect;

import java.lang.reflect.Field;

class Person
{
	private String name;
	private int age;

	public String toString()
	{
		return "Person[name:" + name +
				" , age:" + age + " ]";
	}
}

public class FieldTest
{
	public static void main(String[] args)
			throws Exception
	{
		// 创建一个Person对象
		Person p = new Person();
		// 获取Person类对应的Class对象
		Class<Person> personClazz = Person.class;
		// 获取Person的名为name的Field
		// 使用getDeclaredField，表明可获取各种访问控制符的field
		Field nameField = personClazz.getDeclaredField("name");
		// 设置通过反射访问该Field时取消访问权限检查
		nameField.setAccessible(true);
		// 调用set方法为p对象的name Field设置值
		nameField.set(p, "Lee");
		// 获取Person类名为age的属性
		Field ageField = personClazz.getDeclaredField("age");
		// 设置通过反射访问该Field时取消访问权限检查
		ageField.setAccessible(true);
		// 调用setInt方法为p对象的age Field设置值
		ageField.setInt(p, 30);
		System.out.println(p);
	}
}
