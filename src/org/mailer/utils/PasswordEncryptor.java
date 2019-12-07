package org.mailer.utils;

import java.security.*;

public class PasswordEncryptor {
	private static MessageDigest md;
	public static String getHashCode(String pwd) {
		String dgst = "";
		try {
			md = MessageDigest.getInstance("MD5");
			byte pwdb[] = pwd.getBytes();
			byte pwdc[] = md.digest(pwdb);
			for (int i = 0; i < pwdc.length; i++) {
				dgst = dgst.concat(String.valueOf(pwdc[i]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dgst;
	}
}
