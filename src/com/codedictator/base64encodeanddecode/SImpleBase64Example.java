package com.codedictator.base64encodeanddecode;

import java.util.Base64;

/*
 * This is a simple encoding technique in the Base64.
 * 
 * The encoded string will contain only "A-Za-z0-9+/" these characters set and
 * considers the new line character as line breaker in decoding
 */

public class SImpleBase64Example {
	public static void main(String[] args) {

		String originalString = "Welcome to codedictator \n good day";

		// create base simple encoder object
		Base64.Encoder simpleEncoder = Base64.getEncoder();

		// Encoding string using simple encode
		String encodedString = simpleEncoder.encodeToString(originalString.getBytes());
		System.out.println("Encoded string : " + encodedString);

		// Create base simple decoder object
		Base64.Decoder simpleDecoder = Base64.getDecoder();

		// Deconding the encoded string using decoder
		String decodedString = new String(simpleDecoder.decode(encodedString.getBytes()));
		System.out.println("Decoded String : " + decodedString);
	}
}

/*
 * Java 8 - Base64 API
 * 
 * Simple − Output is mapped to a set of characters lying in A-Za-z0-9+/. The
 * encoder does not add any line feed in output, and the decoder rejects any
 * character other than A-Za-z0-9+/.
 * 
 * URL − Output is mapped to set of characters lying in A-Za-z0-9+_. Output is
 * URL and filename safe.
 * 
 * MIME − Output is mapped to MIME friendly format. Output is represented in
 * lines of no more than 76 characters each, and uses a carriage return '\r'
 * followed by a linefeed '\n' as the line separator. No line separator is
 * present to the end of the encoded output.
 * 
 * 
 * 
 * Java 8 Base64 Methods
 * 
 * Base64 is a base class for encoding and decoding. It has two static inner
 * classes and those are Base64.Encoder, Base64.Decoder.
 * 
 * Use the below methods to get the right encoders and decoders for each type.
 * 
 * -> static Base64.Decoder getDecoder() : Returns a Base64.Decoder that decodes
 * using the Basic type base64 encoding scheme.
 * 
 * -> static Base64.Encoder getEncoder() : Returns a Base64.Encoder that encodes
 * using the Basic type base64 encoding scheme.
 * 
 * -> static Base64.Decoder getMimeDecoder(): Returns a Base64.Decoder that
 * decodes using the MIME type base64 decoding scheme.
 * 
 * -> static Base64.Encoder getMimeEncoder(): Returns a Base64.Encoder that
 * encodes using the MIME type base64 encoding scheme.
 * 
 * -> static Base64.Encoder getMimeEncoder(int lineLength, byte[]
 * lineSeparator): Returns a Base64.Encoder that encodes using the MIME type
 * base64 encoding scheme with specified line length and line separators.
 * 
 * -> static Base64.Decoder getUrlDecoder(): Returns a Base64.Decoder that
 * decodes using the URL and Filename safe type base64 encoding scheme.
 * 
 * -> static Base64.Encoder getUrlEncoder(): Returns a Base64.Encoder that
 * encodes using the URL and Filename safe type base64 encoding scheme.
 */