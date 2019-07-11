package javaDemo;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;

public class EncodingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String encoding = System.getProperty("file.encoding", "UTF-8");
		String name="’≈”Ì";
		byte[] bytes=name.getBytes(Charset.forName("GBK"));
		System.out.println(Arrays.toString(bytes));
		for(byte b: bytes) {
			System.out.print(Integer.toHexString(b & 0xff)+" ");
			System.out.print(b);
		}
	}

}
