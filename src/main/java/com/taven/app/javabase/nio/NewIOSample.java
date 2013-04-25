package com.taven.app.javabase.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.SortedMap;


public class NewIOSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//NIO 即 New IO，是从JDK 1.4开始提供的

	}

	public static void BufferTest()
	{
		// 创建Buffer
		CharBuffer buff = CharBuffer.allocate(8); //①
		System.out.println("capacity: " + buff.capacity());
		System.out.println("limit: " + buff.limit());
		System.out.println("position: " + buff.position());
		// 放入元素
		buff.put('a');
		buff.put('b');
		buff.put('c'); //②
		System.out.println("加入三个元素后，position = "
				+ buff.position());
		// 调用flip()方法
		buff.flip(); //③
		System.out.println("执行flip()后，limit = " + buff.limit());
		System.out.println("position = " + buff.position());
		// 取出第一个元素
		System.out.println("第一个元素(position=0)：" + buff.get()); // ④
		System.out.println("取出一个元素后，position = "
				+ buff.position());
		// 调用clear方法
		buff.clear(); //⑤
		System.out.println("执行clear()后，limit = " + buff.limit());
		System.out.println("执行clear()后，position = "
				+ buff.position());
		System.out.println("执行clear()后，缓冲区内容并没有被清除："
				+ "第三个元素为：" + buff.get(2)); // ⑥
		System.out.println("执行绝对读取后，position = "
				+ buff.position());
	}

	public static void FileChannelTest()
	{
		File f = new File("FileChannelTest.java");
		try
		{
			// 创建FileInputStream，以该文件输入流创建FileChannel
			FileChannel inChannel = new FileInputStream(f).getChannel();
			// 以文件输出流创建FileBuffer，用以控制输出
			FileChannel outChannel = new FileOutputStream("a.txt").getChannel();

			// 将FileChannel里的全部数据映射成ByteBuffer
			MappedByteBuffer buffer = inChannel.map(FileChannel
					.MapMode.READ_ONLY, 0, f.length()); // ①
			// 使用GBK的字符集来创建解码器
			Charset charset = Charset.forName("GBK");
			// 直接将buffer里的数据全部输出
			outChannel.write(buffer); // ②
			// 再次调用buffer的clear()方法，复原limit、position的位置
			buffer.clear();
			// 创建解码器(CharsetDecoder)对象
			CharsetDecoder decoder = charset.newDecoder();
			// 使用解码器将ByteBuffer转换成CharBuffer
			CharBuffer charBuffer = decoder.decode(buffer);
			// CharBuffer的toString方法可以获取对应的字符串
			System.out.println(charBuffer);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}

	public static void RandomFileChannelTest()
	{
		File f = new File("a.txt");
		try
		{
			// 创建一个RandomAccessFile对象
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			// 获取RandomAccessFile对应的Channel
			FileChannel randomChannel = raf.getChannel();

			// 将Channel中所有数据映射成ByteBuffer
			ByteBuffer buffer = randomChannel.map(FileChannel
					.MapMode.READ_ONLY, 0, f.length());
			// 把Channel的记录指针移动到最后
			randomChannel.position(f.length());
			// 将buffer中所有数据输出
			randomChannel.write(buffer);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}

	public static void FileLockTest()
	{

		try
		{
			// 使用FileOutputStream获取FileChannel
			FileChannel channel = new FileOutputStream("a.txt").getChannel();

			// 使用非阻塞式方式对指定文件加锁
			FileLock lock = channel.tryLock();
			// 程序暂停10s

			Thread.sleep(10000);

			// 释放锁
			lock.release();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void CharsetTransform() throws CharacterCodingException
	{
		// 创建简体中文对应的Charset
		Charset cn = Charset.forName("GBK");
		// 获取cn对象对应的编码器和解码器
		CharsetEncoder cnEncoder = cn.newEncoder();
		CharsetDecoder cnDecoder = cn.newDecoder();
		// 创建一个CharBuffer对象
		CharBuffer cbuff = CharBuffer.allocate(8);
		cbuff.put('孙');
		cbuff.put('悟');
		cbuff.put('空');
		cbuff.flip();
		// 将CharBuffer中的字符序列转换成字节序列
		ByteBuffer bbuff = cnEncoder.encode(cbuff);
		// 循环访问ByteBuffer中的每个字节
		for (int i = 0; i < bbuff.capacity(); i++)
		{
			System.out.print(bbuff.get(i) + " ");
		}
		// 将ByteBuffer的数据解码成字符序列
		System.out.println("\n" + cnDecoder.decode(bbuff));
	}

	public static void ShowAllCharsetTest()
	{
		// 获取Java支持的全部字符集
		SortedMap<String, Charset> map = Charset.availableCharsets();
		for (String alias : map.keySet())
		{
			// 输出字符集的别名和对应的Charset对象
			System.out.println(alias + "----->" + map.get(alias));
		}
	}

	public static void ReadFileTest()
	{
		try
		{
			// 创建文件输入流
			FileInputStream fis = new FileInputStream("ReadFile.java");
			// 创建一个FileChannel
			FileChannel fcin = fis.getChannel();

			// 定义一个ByteBuffer对象，用于重复取水
			ByteBuffer bbuff = ByteBuffer.allocate(64);
			// 将FileChannel中数据放入ByteBuffer中
			while (fcin.read(bbuff) != -1)
			{
				// 锁定Buffer的空白区
				bbuff.flip();

				// 创建Charset对象
				Charset charset = Charset.forName("GBK");
				// 创建解码器(CharsetDecoder)对象
				CharsetDecoder decoder = charset.newDecoder();
				// 将ByteBuffer的内容转码
				CharBuffer cbuff = decoder.decode(bbuff);
				System.out.print(cbuff);

				// 将Buffer初始化，为下一次读取数据做准备
				bbuff.clear();
			}
		}
		catch (IOException e) {

		}
	}
}