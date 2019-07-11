package encryptAndDecrypt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESCrypto {
	
	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException, ClassNotFoundException {
		String encryptMsg = AESCrypto.secretEncrypt("你好");
		System.out.println(encryptMsg);
		
		String decryptMsg = AESCrypto.secretDecrypt(encryptMsg);
		System.out.println(decryptMsg);
	}
	
	/**
	 * 对称加密
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws IOException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 */
	private static String secretEncrypt(String message) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
		//获取Cipher(暗号)实例
		Cipher cipher =Cipher.getInstance("AES");

		//得到加密的钥匙
		SecretKey secretKey=KeyGenerator.getInstance("AES").generateKey();
		
		//初始化加密操作,传递加密的钥匙 
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		FileOutputStream fosKey = new FileOutputStream("secretKey.key");
		ObjectOutputStream oosSecretKey = new ObjectOutputStream(fosKey);
		oosSecretKey.writeObject(secretKey);
		oosSecretKey.close();
		fosKey.close();
		
		//加密
		byte[] encrypMsg = cipher.doFinal(message.getBytes());
		
		//用base64进行编码
		Encoder encoder= Base64.getEncoder();
		return encoder.encodeToString(encrypMsg);
	}
	
	/**
	 * 对称解密
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 */
	private static String secretDecrypt(String message) throws NoSuchAlgorithmException, NoSuchPaddingException, IOException, ClassNotFoundException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Decoder decoder = Base64.getDecoder();
		byte[] messageByte = decoder.decode(message);
		
		//获取Cipher(暗号)实例
		Cipher cipher =Cipher.getInstance("AES");
		
		//获取文件中的key进行解密
		FileInputStream fisKey = new FileInputStream("secretKey.key");
		ObjectInputStream oisKey = new ObjectInputStream(fisKey);
		SecretKey key = (SecretKey)oisKey.readObject();
		oisKey.close();
		fisKey.close();
		
		//初始化解密操作,传递加密的钥匙  
        cipher.init(Cipher.DECRYPT_MODE,key);
        
        //解密
        String decryptMsg = new String(cipher.doFinal(messageByte));
        return decryptMsg;
	}
}
