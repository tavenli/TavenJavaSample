package com.taven.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileCharsetUtils {

	private static final Log logger = LogFactory.getLog(FileCharsetUtils.class);

	private static String toCharset = "UTF-8";

	public static void convertEncoding(File orgFile, String toFile, String orgCharset, String toCharset) {
		try {
			String line = "";

			BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(orgFile), orgCharset));

			OutputStream out = new FileOutputStream(toFile);

			while ((line = bReader.readLine()) != null) {
				line += Constants.LINE_SEPARATOR;
				out.write(line.getBytes(toCharset));
			}

			bReader.close();
			out.close();
		}
		catch (Exception e) {
			logger.error("convertEncoding:" + e.getMessage());
		}
	}

	/**
	 * 转换文件编码
	 * 
	 * @param orgFile
	 * @param toFile
	 */
	public static void convertEncoding(File orgFile, String toFile) {

		convertEncoding(orgFile, toFile, Constants.FILE_ENCODING, toCharset);

	}

	private static void convertFile(String orgFileName, String toFileName, String orgCharset, String toCharset) {

		try {
			FileInputStream fis = new FileInputStream(orgFileName);
			StringBuffer content = new StringBuffer();
			DataInputStream in = new DataInputStream(fis);
			BufferedReader d = new BufferedReader(new InputStreamReader(in, orgCharset));

			String line = null;
			while ((line = d.readLine()) != null) {
				content.append(line + Constants.LINE_SEPARATOR);
			}
			d.close();
			in.close();
			fis.close();

			Writer ow = new OutputStreamWriter(new FileOutputStream(toFileName), toCharset);
			ow.write(content.toString());
			ow.close();

		}
		catch (Exception e) {
			logger.error("convertFile:" + e.getMessage());
		}

	}

}
