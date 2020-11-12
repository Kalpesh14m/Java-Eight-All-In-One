package com.codedictator.base64encodeanddecode;

import java.util.Base64;

/*
 * Base64 URL encoder is very similar to the simple encoder. All character set
 * is the same as a simple one but the difference is '_' instead of '\'.
 * 
 * Here is the full URL allowed characters 'A-Za-z0-9+_'.
 * 
 * And also does not add any line separation in the decoder.
 * 
 * use getUrlEncoder() for encoding and getUrlDecoder() for decoding the URL's
 * from Base64.
 */

public class SImpleBase64URLExample {
	public static void main(String[] args) {

		String originalStringURL = "https://www.youtube.com/channel/UCWnMX1pam6Vncf5hnrbKPzw";

		System.out.println("Original String : " + originalStringURL);

		// create url encoder object
		Base64.Encoder simpleEncoder = Base64.getUrlEncoder();

		// Encoding string using url encode
		String encodedString = simpleEncoder.encodeToString(originalStringURL.getBytes());
		System.out.println("Encoded URL string with padding : " + encodedString);

		// encode without padding
		Base64.Encoder withoutPaddingEncoder = Base64.getEncoder().withoutPadding();
		String encodeWithoutPadding = withoutPaddingEncoder.encodeToString(originalStringURL.getBytes());
		System.out.println("Encoded URL string without padding : " + encodeWithoutPadding);

		// Create base simple decoder object
		Base64.Decoder simpleDecoder = Base64.getDecoder();

		// Deconding the encoded string using decoder
		String decodedString = new String(simpleDecoder.decode(encodeWithoutPadding.getBytes()));
		System.out.println("Decoded URL String : " + decodedString);
	}
}
