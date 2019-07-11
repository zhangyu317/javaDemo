package javaDemo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class MainMethod {
	public static void main(String[] args) throws IOException {
//		try {
//			RandomAccessFile raf =new RandomAccessFile(new File("E:\\javaFileTest"), "");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		File demoFile =new File("demo");
		if(!demoFile.exists()) {
			demoFile.mkdirs();
		}
		File file =new File(demoFile,"fat.text");
		if(!file.exists()) {
			file.createNewFile();
		}
		RandomAccessFile raf =new RandomAccessFile(file, "rw");
//		System.out.println(raf.getFilePointer());
		
		raf.write('A');
		System.out.println(raf.getFilePointer());
		raf.write('B');
		System.out.println(raf.getFilePointer());
		raf.writeInt(121111);
		System.out.println(raf.getFilePointer());
		
		Double aDouble = (double) 5;
		byte [] a = new byte[10];
		a[0]='a';
		a[1]='A';
		System.out.println("----------------------");
		System.out.println(a);
		System.out.println("----------------------");
		raf.seek(0);
		byte[] buf = new byte[(int)raf.length()];
		raf.read(buf);
		System.out.println(buf);
		System.out.println(Arrays.toString(buf));
	}
}
