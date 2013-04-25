package com.taven.app.javabase.socket.HalfClose;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(30000);
		Socket socket = ss.accept();
		PrintStream ps = new PrintStream(socket.getOutputStream());
		ps.println("服务器的第一行数据");
		ps.println("服务器的第二行数据");
		//关闭socket的输出流，表明输出数据已经结束
		socket.shutdownOutput();
		//下面语句将输出false，表明socket还未关闭。
		System.out.println(socket.isClosed());
		Scanner scan = new Scanner(socket.getInputStream());
		while (scan.hasNextLine())
		{
			System.out.println(scan.nextLine());
		}
		scan.close();
		socket.close();
		ss.close();
	}
}
