package IOdemo;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo {
	

	public static void main(String[] args) throws IOException {
		//如果该文件不存在，则直接创建，如果存在，删除后创建
		//new FileOutputStream(fileName,true);表示在文件内容追加
		FileOutputStream out = new FileOutputStream("D:\\javaIoFiles\\a.text\\Hadoop",true);
		out.write('A');//写出了'A'的低8位
		out.write('B');//写出了'B'的低8位
		int a = 10;//write只能写8位，因此写一个int需要写4次
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a);
		byte[] gbk = "中国".getBytes("gbk");
		out.write(gbk);
		out.close();
		IOUtils.printHex("D:\\javaIoFiles\\a.text\\Hadoop");
	}
	

}
