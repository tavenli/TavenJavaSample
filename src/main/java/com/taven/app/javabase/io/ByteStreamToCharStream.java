package com.taven.app.javabase.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.taven.utils.Constants;

/**
 * <pre>
 * 字节流 转 字符流
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-6-12
 *         </p>
 */
public class ByteStreamToCharStream {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		//使用InputStreamReader 和 OutputStreamWriter 可以将 字节流 转为 字符流，也可以实现编码的转换

		FileInputStream fileInputStream = new FileInputStream("d:\\test.txt");

		InputStreamReader inputReader = new InputStreamReader(fileInputStream, Constants.FILE_ENCODING);

		BufferedReader reader = new BufferedReader(inputReader);

		FileOutputStream fileOutputStream = new FileOutputStream("d:\\test2.txt");
		OutputStreamWriter outWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");

		String line = "";
		while ((line = reader.readLine()) != null) {

			line += Constants.LINE_SEPARATOR;
			outWriter.write(line);

		}

		//最好用 try{} finaly{} 来关闭
		reader.close();
		outWriter.close();

	}

}
