package com.taven.app.javabase.socket.HalfClose;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket("localhost", 30000);
		Scanner scan = new Scanner(s.getInputStream());
		while (scan.hasNextLine())
		{
			System.out.println(scan.nextLine());
		}
		PrintStream ps = new PrintStream(s.getOutputStream());
		ps.println("客户端的第一行数据");
		ps.println("客户端的第二行数据");
		ps.close();
		scan.close();
		s.close();
	}
}
