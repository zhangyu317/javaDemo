package IOdemo;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutDemo {
	

	public static void main(String[] args) throws IOException {
		//������ļ������ڣ���ֱ�Ӵ�����������ڣ�ɾ���󴴽�
		//new FileOutputStream(fileName,true);��ʾ���ļ�����׷��
		FileOutputStream out = new FileOutputStream("D:\\javaIoFiles\\a.text\\Hadoop",true);
		out.write('A');//д����'A'�ĵ�8λ
		out.write('B');//д����'B'�ĵ�8λ
		int a = 10;//writeֻ��д8λ�����дһ��int��Ҫд4��
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a);
		byte[] gbk = "�й�".getBytes("gbk");
		out.write(gbk);
		out.close();
		IOUtils.printHex("D:\\javaIoFiles\\a.text\\Hadoop");
	}
	

}
