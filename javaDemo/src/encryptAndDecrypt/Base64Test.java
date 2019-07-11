package encryptAndDecrypt;

import java.util.Base64;
import java.util.Base64.Encoder;

public class Base64Test {

	public static void main(String[] args) {
		Encoder encoder= Base64.getEncoder();
		String message = encoder.encodeToString("asdasd sasdasdas".getBytes());
		String message2 = encoder.encodeToString("asdasdsasdasdas".getBytes());
		System.out.println(message);
		System.out.println(message2);
	}
	
}
