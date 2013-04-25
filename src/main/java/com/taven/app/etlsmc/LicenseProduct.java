package com.taven.app.etlsmc;

import java.io.File;
import java.io.FileOutputStream;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * <pre>
 * 一个生成简单License的Demo
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-4-16
 *         </p>
 */
public class LicenseProduct {

	private final static String DES = "DES";

	private final static String KEY = "fenetetl";// 字节数必须是8的倍数

	public static void main(String[] args) throws Exception {
		File dat = new File("license.dat");
		if (dat.exists())
			dat.delete();
		System.out.println("ETL_PLUS产品License文件生成程序!");
		System.out.println("----------------------------");
		System.out.println("请输入使用到期时间,格式为yyyy-MM-dd,如果使用无限制输入'forever'");
		Scanner reader = new Scanner(System.in);
		String source = "";
		while (reader.hasNextLine()) {
			source = reader.nextLine();
			System.out.println("您输入的是:" + source);
			if ("forever".equals(source))
				break;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				format.parse(source);
				break;
			}
			catch (Exception e) {
				System.out.println("输入格式错误,请重新输入");
			}
		}

		// DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 从原始密匙数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(KEY.getBytes());
		// 创建一个密匙工厂，然后用它把DESKeySpec转换成
		// 一个SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(DES);
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
		// 现在，获取数据并加密
		// 正式执行加密操作
		FileOutputStream file = new FileOutputStream("license.dat");
		file.write(cipher.doFinal(source.getBytes()));
		file.close();
	}
}
