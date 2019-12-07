package test;

public class UserInsertMain {
	public static void main (String args[]) {
		System.out.println(org.mailer.utils.PasswordEncryptor.getHashCode(org.mailer.utils.Constants.SALT.concat("password")));
	}
}
