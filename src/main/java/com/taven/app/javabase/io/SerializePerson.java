package com.taven.app.javabase.io;

public class SerializePerson implements java.io.Serializable
{
	private String name;
	//transient 关键字让该类序列化时，忽略该属性字段（transient 只能修饰 Field）
	private transient int age;

	// 注意此处没有提供无参数的构造器!
	public SerializePerson(String name, int age)
	{
		System.out.println("有参数的构造器");
		this.name = name;
		this.age = age;
	}

	// 省略name与age的setter和getter方法

	// name的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	// age的setter和getter方法
	public void setAge(int age)
	{
		this.age = age;
	}

	public int getAge()
	{
		return this.age;
	}

	// Externalizable 接口的两个方法实现

	/*		private void writeObject(java.io.ObjectOutputStream out) throws IOException
			{
				// 将name Field的值反转后写入二进制流
				out.writeObject(new StringBuffer(name).reverse());
				out.writeInt(age);
			}

			private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException
			{
				// 将读取的字符串反转后赋给name Field
				this.name = ((StringBuffer) in.readObject()).reverse()
						.toString();
				this.age = in.readInt();
			}*/

}