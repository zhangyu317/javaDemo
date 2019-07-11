package IOdemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsrAndOswDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream("D:\\javaIoFiles\\a.text\\hadoop");
		InputStreamReader isr =new InputStreamReader(in,"gbk");//不写，默认是项目编码
		
		/*int c;
		while((c=isr.read())!=-1) {
			System.out.print((char)c);
		}*/
		char[] buf = new char[8*1024];
		int c;
		//批量读取，放入buf这个字符数组，从第0个位置开始放置，最多放buf.length个
		//返回的是读到的字符个数
		while ((c = isr.read(buf,0,buf.length))!=-1) {
			String string =new String(buf, 0, c);
			System.out.print(string);
		}
	}

}
