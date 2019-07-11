package IOdemo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
//		File demo = new File("D:\\javaIoFiles\\a.text");
		File demo = new File("demo");//在项目根目录下创建文件夹
		if(!demo.exists()) {
			demo.mkdir();
		}
		File file = new File(demo,"a.text");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		RandomAccessFile raf= new RandomAccessFile(file, "rw");
		//指针位置（下载大文件的时候这个指针很有用： 多个线程读取 利用指针拼接成目标文件）
		System.out.println(raf.getFilePointer());;
		
		raf.write('A');//只写一个字节，因为'A' char占两个字节(当然有可能已经把'A'写进去了，因为一个字节已经可以表示'A'了)
		System.out.println(raf.getFilePointer());
		
		int i = 0x7fffffff;
		//用write方法每次只能写一个字节，如果要把i写进去就得写4次
		raf.write(i >>> 24);//右移24位 把高八位
		raf.write(i >>> 16);
		raf.write(i >>> 8);
		raf.write(i);
		System.out.println(raf.getFilePointer());
		
		//可以直接写一个int
		raf.writeInt(i);
		
		String string = "中";
		byte[] gbk = string.getBytes("gbk");
		raf.write(gbk);
		System.out.println(raf.length());
		
		//读文件，必须把指针移到头部
		raf.seek(0);
		//一次性读取,把文件中的内容读到字节数组中
		byte[] buf = new byte[(int)raf.length()];
		raf.read(buf);
		System.out.println(Arrays.toString(buf));
		
		//以16进制读取buf
		for(byte b:buf) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		raf.close();
	}

}
