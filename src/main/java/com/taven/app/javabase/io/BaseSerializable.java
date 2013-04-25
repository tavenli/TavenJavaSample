package com.taven.app.javabase.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BaseSerializable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//在java中，序列化接口有两种，分别是：
		//java.io.Serializable 
		//java.io.Externalizable

	}

	public static void WriteSerializeObject()
	{
		try
		{
			// 创建一个ObjectOutputStream输出流
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("object.txt"));

			SerializePerson per = new SerializePerson("孙悟空", 500);
			// 将per对象写入输出流
			oos.writeObject(per);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}

	public static void ReadSerializeObject()
	{
		try
		{
			// 创建一个ObjectInputStream输入流
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"));

			// 从输入流中读取一个Java对象，并将其强制类型转换为Person类
			SerializePerson p = (SerializePerson) ois.readObject();
			System.out.println("名字为：" + p.getName() + "\n年龄为：" + p.getAge());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
