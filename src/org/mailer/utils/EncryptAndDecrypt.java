package org.mailer.utils;


import org.apache.commons.codec.binary.Base64;

/*
 * This class is responsible to encrypt/ decrypt the password
 * @author  
 */
public class EncryptAndDecrypt {
	/**

	 * method for encrypting a string.
	 * @param str Description of the Parameter
	 * @return String the encrypted string.
	 * @exception SecurityException Description of the Exception
	 */

	public synchronized static String encrypt(String str) throws SecurityException	{
		try{
			String output = new String(Base64.encodeBase64(str.getBytes()));
			return output;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * method for encrypting a string.
	 * @param str Description of the Parameter
	 * @return String the encrypted string.
	 * @exception SecurityException Description of the Exception
	 */

	public synchronized static String decrypt(String str)throws SecurityException{
		try{
			String decodeOutput = new String(Base64.decodeBase64(str.getBytes()));
			return decodeOutput;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * static method for decrypting a string.
	 * @param str Description of the Parameter
	 * @return String the encrypted string.
	 * @exception SecurityException Description of the Exception
	 */

	public static String staticDecrypt(String str)throws SecurityException{
		try{
			String decodeOutput = new String(Base64.decodeBase64(str.getBytes()));
			return decodeOutput;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}