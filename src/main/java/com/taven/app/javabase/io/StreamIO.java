package com.taven.app.javabase.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PushbackReader;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.io.StringWriter;

public class StreamIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//常用的 输入/输出 类

		/**
		 * 字节流的输入/输出类
		 * 
		 * FileInputStream FileOutputSream
		 * ByteArrayInputStram ByteArrayOutputStream
		 * PipedInputStream PipedOutputStream
		 * PrintStream
		 * 
		 * 字节的缓冲流：BufferedInputStream BufferedOutputStream
		 * 
		 * 
		 * 
		 * 字符流的输入/输出类
		 * 
		 * FileReader FileWriter
		 * CharArrayReader CharArrayWriter
		 * PipedReader PipedWriter
		 * StringReader StringWriter
		 * PrintWriter
		 * 
		 * 字符的缓冲流：BufferedReader BufferedWriter
		 * 
		 * 
		 * 字节流转字符
		 * 
		 * InputStreamReader OutputStreamWriter
		 * 
		 * 
		 * 还有其它操作类可以查阅书籍资料，例如：对象流、推回输入流、特殊流 等
		 * 
		 * 
		 */

		//以下是对流的基本操作

	}

	public static void FileInputStreamTest() throws IOException
	{
		// 创建字节输入流
		FileInputStream fis = new FileInputStream("FileInputStreamTest.java");
		// 创建一个长度为1024的“竹筒”
		byte[] bbuf = new byte[1024];
		// 用于保存实际读取的字节数
		int hasRead = 0;
		// 使用循环来重复“取水”过程
		while ((hasRead = fis.read(bbuf)) > 0)
		{
			// 取出“竹筒”中水滴（字节），将字节数组转换成字符串输入！
			System.out.print(new String(bbuf, 0, hasRead));
		}
		// 关闭文件输入流，放在finally块里更安全
		fis.close();
	}

	public static void FileReaderTest()
	{
		try
		{
			// 创建字符输入流
			FileReader fr = new FileReader("FileReaderTest.java");
			// 创建一个长度为32的“竹筒”
			char[] cbuf = new char[32];
			// 用于保存实际读取的字符数
			int hasRead = 0;
			// 使用循环来重复“取水”过程
			while ((hasRead = fr.read(cbuf)) > 0)
			{
				// 取出“竹筒”中水滴（字符），将字符数组转换成字符串输入！
				System.out.print(new String(cbuf, 0, hasRead));
			}
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}

	public static void FileWriterTest()
	{
		try
		{
			FileWriter fw = new FileWriter("poem.txt");

			fw.write("锦瑟 - 李商隐\r\n");
			fw.write("锦瑟无端五十弦，一弦一柱思华年。\r\n");
			fw.write("庄生晓梦迷蝴蝶，望帝春心托杜鹃。\r\n");
			fw.write("沧海月明珠有泪，蓝田日暖玉生烟。\r\n");
			fw.write("此情可待成追忆，只是当时已惘然。\r\n");
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	public static void FileOutputStreamTest()
	{
		try
		{
			// 创建字节输入流
			FileInputStream fis = new FileInputStream("FileOutputStreamTest.java");
			// 创建字节输出流
			FileOutputStream fos = new FileOutputStream("newFile.txt");

			byte[] bbuf = new byte[32];
			int hasRead = 0;
			// 循环从输入流中取出数据
			while ((hasRead = fis.read(bbuf)) > 0)
			{
				// 每读取一次，即写入文件输出流，读了多少，就写多少。
				fos.write(bbuf, 0, hasRead);
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	//--------------------------------------------------
	//处理流 的用法
	//只要流的构造参数不是一个物理节点，而是已经存在的流，那么这种流就是处理流
	//优势：开发人员输入/输出操作更简单；处理流方式使执行效率更高；

	public static void PrintStreamTest()
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("test.txt");

			//创建处理流时，将节点流对象作为构造参数传入
			PrintStream ps = new PrintStream(fos);
			// 使用PrintStream执行输出
			ps.println("普通字符串");
			// 直接使用PrintStream输出对象
			ps.println(new StreamIO());

		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	public static void StringReaderTest()
	{
		String src = "从明天起，做一个幸福的人\n"
				+ "喂马，劈柴，周游世界\n"
				+ "从明天起，关心粮食和蔬菜\n"
				+ "我有一所房子，面朝大海，春暖花开\n"
				+ "从明天起，和每一个亲人通信\n"
				+ "告诉他们我的幸福\n";

		char[] buffer = new char[32];
		int hasRead = 0;

		try
		{
			StringReader sr = new StringReader(src);
			// 采用循环读取的访问读取字符串
			while ((hasRead = sr.read(buffer)) > 0)
			{
				System.out.print(new String(buffer, 0, hasRead));
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}

		// 创建StringWriter时，实际上以一个StringBuffer作为输出节点
		// 下面指定的20就是StringBuffer的初始长度
		StringWriter sw = new StringWriter();

		// 调用StringWriter的方法执行输出
		sw.write("有一个美丽的新世界，\n");
		sw.write("她在远方等我,\n");
		sw.write("哪里有天真的孩子，\n");
		sw.write("还有姑娘的酒窝\n");
		System.out.println("----下面是sw的字符串节点里的内容----");
		// 使用toString()方法返回StringWriter的字符串节点的内容
		System.out.println(sw.toString());
	}

	/**
	 * 转换流
	 * 
	 * InputStreamReader：将字节输入流转换成字符输入流
	 * OutputStreamWriter：将字节输出流转换成字符输出流
	 */
	public static void InputStreamReaderTest()
	{
		try
		{
			// 将Sytem.in对象转换成Reader对象
			InputStreamReader reader = new InputStreamReader(System.in);
			//将普通Reader包装成BufferedReader
			BufferedReader br = new BufferedReader(reader);

			String buffer = null;
			//采用循环方式来一行一行的读取
			while ((buffer = br.readLine()) != null)
			{
				//如果读取的字符串为"exit"，程序退出
				if (buffer.equals("exit"))
				{
					System.exit(1);
				}
				//打印读取的内容
				System.out.println("输入内容为:" + buffer);
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	/**
	 * 推回输入流
	 */
	public static void PushbackReaderTest()
	{
		try
		{
			// 创建一个PushbackReader对象，指定推回缓冲区的长度为64
			PushbackReader pr = new PushbackReader(new FileReader("PushbackTest.java"), 64);

			char[] buf = new char[32];
			// 用以保存上次读取的字符串内容
			String lastContent = "";
			int hasRead = 0;
			// 循环读取文件内容
			while ((hasRead = pr.read(buf)) > 0)
			{
				// 将读取的内容转换成字符串
				String content = new String(buf, 0, hasRead);
				int targetIndex = 0;
				// 将上次读取的字符串和本次读取的字符串拼起来，
				// 查看是否包含目标字符串, 如果包含目标字符串
				if ((targetIndex = (lastContent + content).indexOf("new PushbackReader")) > 0)
				{
					// 将本次内容和上次内容一起推回缓冲区
					pr.unread((lastContent + content).toCharArray());
					// 指定读取前面len个字符
					int len = targetIndex > 32 ? 32 : targetIndex;
					// 再次读取指定长度的内容（就是目标字符串之前的内容）
					pr.read(buf, 0, len);
					// 打印读取的内容
					System.out.print(new String(buf, 0, len));
					System.exit(0);
				}
				else
				{
					// 打印上次读取的内容
					System.out.print(lastContent);
					// 将本次内容设为上次读取的内容
					lastContent = content;
				}
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	/**
	 * 通过JVM读写其他进程的数据
	 */
	public static void ReadFromProcessTest()
	{

		try
		{
			// 运行javac命令，返回运行该命令的子进程
			Process p = Runtime.getRuntime().exec("javac");

			// 以p进程的错误流创建BufferedReader对象
			// 这个错误流对本程序是输入流，对p进程则是输出流
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));

			String buff = null;
			// 采取循环方式来读取p进程的错误输出
			while ((buff = br.readLine()) != null)
			{
				System.out.println(buff);
			}
		}
		catch (IOException e) {

		}
	}

	/**
	 * 除了可以读取其它进程的流，还可以向其它进程的流对象写入数据
	 */
	public static void WriteToProcessTest()
	{
		try
		{
			// 运行java ReadStandard 命令，返回运行该命令的子进程
			// ReadStandard类的定义在该方面下面
			Process p = Runtime.getRuntime().exec("java ReadStandard");

			// 以p进程的输出流创建PrintStream对象
			// 这个输出流对本程序是输出流，对p进程则是输入流
			PrintStream ps = new PrintStream(p.getOutputStream());

			// 向ReadStandard程序写入内容，这些内容将被ReadStandard读取
			ps.println("普通字符串");

		}
		catch (IOException e) {

		}

	}

	/*	//------------------------------------------------------------
		// 定义一个ReadStandard类，该类可以接受标准输入，
		// 并将标准输入写入out.txt文件。
		class ReadStandard
		{
			public static void main(String[] args)
			{
				try
				{
					// 使用System.in创建Scanner对象，用于获取标准输入
					Scanner sc = new Scanner(System.in);
					PrintStream ps = new PrintStream(new FileOutputStream("out.txt"));

					// 增加下面一行将只把回车作为分隔符
					sc.useDelimiter("\n");
					// 判断是否还有下一个输入项
					while (sc.hasNext())
					{
						// 输出输入项
						ps.println("键盘输入的内容是：" + sc.next());
					}
				}
				catch (IOException ioe)
				{
					ioe.printStackTrace();
				}
			}
		}
		//------------------------------------------------------------
	*/

	/**
	 * 随机访问文件类
	 * 
	 * 可以从一个文件的任意位置开始读，也可以从任意位置开始写
	 * 
	 * 特别适合一些特殊需求的操作，比如多线程下载文件等
	 */
	public static void RandomAccessFileTest()
	{
		try
		{
			RandomAccessFile raf = new RandomAccessFile("RandomAccessFileTest.java", "r");

			// 获取RandomAccessFile对象文件指针的位置，初始位置是0
			System.out.println("RandomAccessFile的文件指针的初始位置：" + raf.getFilePointer());

			// 移动raf的文件记录指针的位置
			raf.seek(300);
			byte[] bbuf = new byte[1024];
			// 用于保存实际读取的字节数
			int hasRead = 0;
			// 使用循环来重复“取水”过程
			while ((hasRead = raf.read(bbuf)) > 0)
			{
				// 取出“竹筒”中水滴（字节），将字节数组转换成字符串输入！
				System.out.print(new String(bbuf, 0, hasRead));
			}
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}

	/**
	 * 任意位置追加
	 */
	public static void RandomAccessFileAppendTest()
	{
		try
		{
			//以读、写方式打开一个RandomAccessFile对象
			RandomAccessFile raf = new RandomAccessFile("out.txt", "rw");

			//将记录指针移动到out.txt文件的最后
			raf.seek(raf.length());
			raf.write("追加的内容！\r\n".getBytes());
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}

	/**
	 * 任意位置插入
	 * 
	 * 例如：RandomAccessFileInsertTest("InsertContent.java" , 45 , "插入的内容\r\n");
	 * 
	 * @param fileName
	 * @param pos
	 * @param insertContent
	 */
	public static void RandomAccessFileInsertTest(String fileName, long pos, String insertContent)
	{

		try
		{
			File tmp = File.createTempFile("tmp", null);
			tmp.deleteOnExit();

			RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
			// 创建一个临时文件来保存插入点后的数据
			FileOutputStream tmpOut = new FileOutputStream(tmp);
			FileInputStream tmpIn = new FileInputStream(tmp);

			raf.seek(pos);
			// ------下面代码将插入点后的内容读入临时文件中保存------
			byte[] bbuf = new byte[64];
			// 用于保存实际读取的字节数
			int hasRead = 0;
			// 使用循环方式读取插入点后的数据
			while ((hasRead = raf.read(bbuf)) > 0)
			{
				// 将读取的数据写入临时文件
				tmpOut.write(bbuf, 0, hasRead);
			}
			// ----------下面代码插入内容----------
			// 把文件记录指针重新定位到pos位置
			raf.seek(pos);
			// 追加需要插入的内容
			raf.write(insertContent.getBytes());
			// 追加临时文件中的内容
			while ((hasRead = tmpIn.read(bbuf)) > 0)
			{
				raf.write(bbuf, 0, hasRead);
			}
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}
