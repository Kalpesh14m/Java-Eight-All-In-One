package com.codedictator.base64encodeanddecode;

import java.util.Base64;

/*
 * By default, encoding pads with the '=' double equal operator if the encoded
 * string length is not met the desired length.
 * 
 * Typically, an encoded string should be multiples of 3 otherwise it will be
 * added with = character.
 * 
 * On the other side, while decoding all extra padded characters will be
 * discarded.
 * 
 * If you do want to be decoded then encode without padding using
 * withoutPadding().
 * 
 * withoutPadding() method helps to skip the padding of the output.
 * 
 * Many developers think that no padding encoded string cannot be decoded back
 * to the original string.
 * 
 * But, it is wrong and Base64.Decode api provides flexibility to decode back.
 */
public class SImpleBase64WithoutPaddingExample {
	public static void main(String[] args) {

		String originalString = "Welcome to codedictator \n good day";

		System.out.println("Original String : " + originalString);
		// create base simple encoder object
		Base64.Encoder simpleEncoder = Base64.getEncoder();

		// Encoding string using simple encode
		String encodedString = simpleEncoder.encodeToString(originalString.getBytes());
		System.out.println("Encoded string with padding : " + encodedString);

		// encode without padding
		Base64.Encoder withoutPaddingEncoder = Base64.getEncoder().withoutPadding();
		String encodeWithoutPadding = withoutPaddingEncoder.encodeToString(originalString.getBytes());
		System.out.println("Encoded string without padding : " + encodeWithoutPadding);

		// Create base simple decoder object
		Base64.Decoder simpleDecoder = Base64.getDecoder();

		// Deconding the encoded string using decoder
		String decodedString = new String(simpleDecoder.decode(encodeWithoutPadding.getBytes()));
		System.out.println("Decoded String : " + decodedString);
	}
}
