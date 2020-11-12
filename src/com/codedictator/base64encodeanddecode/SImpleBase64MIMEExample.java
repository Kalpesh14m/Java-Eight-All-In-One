package com.codedictator.base64encodeanddecode;

import java.util.Base64;
import java.util.UUID;

/*
 * MIME encoding is another type of Base64 encode and decode. MIME technique is
 * mainly used for more data such as ASCII, email contents attachments, audio,
 * video, and images that need to be encoded and decoded.
 * 
 * Use Base64.getMimeEncoder() for MIME data encoding and
 * Base64.getMimeDecoder() for MIME data decoding.
 * 
 * The encoded content byMIME type will be divided into multiple lines and each
 * line length not exceeding 76 characters. Each line ends with a carriage
 * return such as \n or \r.
 */

public class SImpleBase64MIMEExample {

	public static void main(String[] args) {
		// adding random 10 UUID values.
		String mimeContent = generateMimeBuffer().toString();

		System.out.println("Original mime buffer length: " + mimeContent.length());

		// Base64 MIME Encode
		Base64.Encoder mimeEncode = Base64.getMimeEncoder();
		String mimeEncodedStr = mimeEncode.encodeToString(mimeContent.getBytes());
		System.out.println("MIME encoded string : " + mimeEncodedStr);

		// Base64 MIME Decode
		Base64.Decoder mimeDecode = Base64.getMimeDecoder();
		String mimeDecodedStr = new String(mimeDecode.decode(mimeEncodedStr.getBytes()));
		System.out.println("MIME decoded string length: " + mimeDecodedStr.length());
	}

	/**
	 * Genreates random 10 UUID numbers and adds to the StringBuffer.
	 *
	 * @return
	 */
	private static StringBuffer generateMimeBuffer() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			buffer.append(UUID.randomUUID());
		}
		return buffer;
	}
}
