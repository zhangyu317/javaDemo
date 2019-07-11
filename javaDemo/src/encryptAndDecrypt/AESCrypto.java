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
		String encryptMsg = AESCrypto.secretEncrypt("���");
		System.out.println(encryptMsg);
		
		String decryptMsg = AESCrypto.secretDecrypt(encryptMsg);
		System.out.println(decryptMsg);
	}
	
	/**
	 * �ԳƼ���
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws IOException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 */
	private static String secretEncrypt(String message) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
		//��ȡCipher(����)ʵ��
		Cipher cipher =Cipher.getInstance("AES");

		//�õ����ܵ�Կ��
		SecretKey secretKey=KeyGenerator.getInstance("AES").generateKey();
		
		//��ʼ�����ܲ���,���ݼ��ܵ�Կ�� 
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		FileOutputStream fosKey = new FileOutputStream("secretKey.key");
		ObjectOutputStream oosSecretKey = new ObjectOutputStream(fosKey);
		oosSecretKey.writeObject(secretKey);
		oosSecretKey.close();
		fosKey.close();
		
		//����
		byte[] encrypMsg = cipher.doFinal(message.getBytes());
		
		//��base64���б���
		Encoder encoder= Base64.getEncoder();
		return encoder.encodeToString(encrypMsg);
	}
	
	/**
	 * �Գƽ���
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
		
		//��ȡCipher(����)ʵ��
		Cipher cipher =Cipher.getInstance("AES");
		
		//��ȡ�ļ��е�key���н���
		FileInputStream fisKey = new FileInputStream("secretKey.key");
		ObjectInputStream oisKey = new ObjectInputStream(fisKey);
		SecretKey key = (SecretKey)oisKey.readObject();
		oisKey.close();
		fisKey.close();
		
		//��ʼ�����ܲ���,���ݼ��ܵ�Կ��  
        cipher.init(Cipher.DECRYPT_MODE,key);
        
        //����
        String decryptMsg = new String(cipher.doFinal(messageByte));
        return decryptMsg;
	}
}
