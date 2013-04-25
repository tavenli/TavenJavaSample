package com.taven.app.etlsmc;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

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
public class EtlLicenseMain {

	private final static String DES = "DES";

	private final static String KEY = "fenetetl";// 字节数必须是8的倍数

	public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {

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

		String licenseSr = "ETL SMC";

		byte[] pasByte = cipher.doFinal(licenseSr.getBytes("utf-8"));
		BASE64Encoder base64Encoder = new BASE64Encoder();
		String result = base64Encoder.encode(pasByte);

		//ETL Plus\Tomcat\bin\LT-License.xml
		result = "sLaH1WosbkbS0VmJoVN2P7e+hgRfdNPv45P7muuysajeY2Pl+iUlwKrPjBhk7VRes9IpvtVvFCqnmGvhSVDW+A==";

		Cipher deCipher = Cipher.getInstance(DES);
		// 用密匙初始化Cipher对象
		deCipher.init(Cipher.DECRYPT_MODE, securekey, sr);
		BASE64Decoder base64Decoder = new BASE64Decoder();
		byte[] dePasByte = deCipher.doFinal(base64Decoder.decodeBuffer(result));
		String deResult = new String(dePasByte, "UTF-8");
		deResult = new String(dePasByte);
		deResult = new String(dePasByte, "GBK");
		deResult = new String(dePasByte, "GB2312");

	}

}
