package IOdemo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
//		File demo = new File("D:\\javaIoFiles\\a.text");
		File demo = new File("demo");//����Ŀ��Ŀ¼�´����ļ���
		if(!demo.exists()) {
			demo.mkdir();
		}
		File file = new File(demo,"a.text");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		RandomAccessFile raf= new RandomAccessFile(file, "rw");
		//ָ��λ�ã����ش��ļ���ʱ�����ָ������ã� ����̶߳�ȡ ����ָ��ƴ�ӳ�Ŀ���ļ���
		System.out.println(raf.getFilePointer());;
		
		raf.write('A');//ֻдһ���ֽڣ���Ϊ'A' charռ�����ֽ�(��Ȼ�п����Ѿ���'A'д��ȥ�ˣ���Ϊһ���ֽ��Ѿ����Ա�ʾ'A'��)
		System.out.println(raf.getFilePointer());
		
		int i = 0x7fffffff;
		//��write����ÿ��ֻ��дһ���ֽڣ����Ҫ��iд��ȥ�͵�д4��
		raf.write(i >>> 24);//����24λ �Ѹ߰�λ
		raf.write(i >>> 16);
		raf.write(i >>> 8);
		raf.write(i);
		System.out.println(raf.getFilePointer());
		
		//����ֱ��дһ��int
		raf.writeInt(i);
		
		String string = "��";
		byte[] gbk = string.getBytes("gbk");
		raf.write(gbk);
		System.out.println(raf.length());
		
		//���ļ��������ָ���Ƶ�ͷ��
		raf.seek(0);
		//һ���Զ�ȡ,���ļ��е����ݶ����ֽ�������
		byte[] buf = new byte[(int)raf.length()];
		raf.read(buf);
		System.out.println(Arrays.toString(buf));
		
		//��16���ƶ�ȡbuf
		for(byte b:buf) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		raf.close();
	}

}
