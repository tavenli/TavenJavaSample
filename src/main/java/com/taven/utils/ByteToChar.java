package com.taven.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class ByteToChar {

	public static CharBuffer convertByteToChar(ByteBuffer buffer) throws CharacterCodingException {

		return buffer.asCharBuffer();

	}

	public static ByteBuffer convertByCharsetName(ByteBuffer buffer) throws CharacterCodingException {

		CharsetDecoder inDecoder = Charset.forName("GBK").newDecoder();
		CharsetEncoder outEncoder = Charset.forName("UTF-8").newEncoder();

		CharBuffer charBuffer = inDecoder.decode(buffer);
		ByteBuffer rbuffer = outEncoder.encode(charBuffer);

		return rbuffer;

	}

	public static ByteBuffer convertCharToByte(CharBuffer buffer, String charsetName) throws CharacterCodingException {

		CharsetEncoder outEncoder = Charset.forName(charsetName).newEncoder();
		ByteBuffer rbuffer = outEncoder.encode(buffer);
		return rbuffer;

	}

	/**
	 * 该方式或许有一定的缺陷
	 * 
	 * @param input
	 * @param outStream
	 * @throws IOException
	 */
	public static void readByte(ReadableByteChannel input, OutputStream outStream) throws IOException {

		CharsetDecoder inDecoder = Charset.forName("GBK").newDecoder();
		CharsetEncoder outEncoder = Charset.forName("UTF-8").newEncoder();

		while (true) {
			ByteBuffer dst = ByteBuffer.allocate(1024);
			while (input.read(dst) != -1) {
				dst.flip();

				//-------------------
				//编码转换
				CharBuffer charBuffer = inDecoder.decode(dst);
				ByteBuffer buffer = outEncoder.encode(charBuffer);
				//-------------------

				while (buffer.remaining() > 0) {
					outStream.write(buffer.get());

				}

				dst.clear();
			}
		}
	}

}
