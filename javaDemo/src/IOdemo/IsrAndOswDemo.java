package IOdemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsrAndOswDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream("D:\\javaIoFiles\\a.text\\hadoop");
		InputStreamReader isr =new InputStreamReader(in,"gbk");//��д��Ĭ������Ŀ����
		
		/*int c;
		while((c=isr.read())!=-1) {
			System.out.print((char)c);
		}*/
		char[] buf = new char[8*1024];
		int c;
		//������ȡ������buf����ַ����飬�ӵ�0��λ�ÿ�ʼ���ã�����buf.length��
		//���ص��Ƕ������ַ�����
		while ((c = isr.read(buf,0,buf.length))!=-1) {
			String string =new String(buf, 0, c);
			System.out.print(string);
		}
	}

}
