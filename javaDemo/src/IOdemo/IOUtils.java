package IOdemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ��ȡָ���ļ�����,����16�������������̨��
 * ����ÿ���10��byte����
 * @author ZhangY
 *
 *
 *
 */
public class IOUtils {
	public static void printHex(String fileName) throws IOException {
		//���ļ���Ϊ�ֽ������ж�����
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int i =1;
		while ((b = in.read())!= -1) {
			if (b<= 0xf) {
				//��λ��ǰ�油��
				System.out.print("0");
			}
			//������bת��Ϊ16���Ʊ�ʾ���ַ���
			System.out.print(Integer.toHexString(b)+ " ");
			//����
			if(i++%10 == 0) {
				System.out.println();
			}
		}
		in.close();
	}
	
	public static void printHexByByteArray(String fileName) throws IOException{
		FileInputStream in = new FileInputStream(fileName);
		byte[] buf = new byte[20 * 1024];
		//��in��������ȡ�ֽڣ����뵽buf����ֽ������У�
		//�ӵ�0��λ�ÿ�ʼ�ţ�����buf.length��
		//*���ص��Ƕ������ֽڵĸ�������Ϊ�п���û�а�����ֽ����������
		
		//����һ��
		
		/*int bytes = in.read(buf, 0, buf.length);
		int j = 1;
		for(int i=0;i<bytes;i++) {
			//������bת��Ϊ16���Ʊ�ʾ���ַ���
			System.out.print(Integer.toHexString(buf[i] & 0xff)+ " ");
			//����
			if(j++%10 == 0) {
				System.out.println();
			}
		}*/
		
		
		//��������
		int bytes = 0;
		int j = 1;
		while((bytes = in.read(buf, 0, buf.length))!=-1) {
			for(int i =0;i<bytes;i++) {
				System.out.print(Integer.toHexString(buf[i] & 0xff)+ " ");// 0xff��byte����Ϊ8λ��int��32λ��Ϊ�˱�������ת������ͨ��& 0xff����24λ����
				//����
				if(j++%10 == 0) {
					System.out.println();
				}
			}
		}
		in.close();
	}
	
	
	/**
	 * �ļ��������ֽ�������ȡ(���)
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException {
		if(!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ�"+srcFile+"������.");
		}
		if(!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile+"�����ļ�.");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] buf = new byte[8*1024];
		int i;
		while((i=in.read(buf,0,buf.length))!=-1) {
			out.write(buf, 0, i);
			out.flush();//��ü���
		}
		System.out.println("���Ƴɹ���");
		in.close();
		out.close();
	}
	
	/**
	 * ���ô�������ֽ��� �����ļ��Ŀ���
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByBuffer(File srcFile, File destFile) throws IOException {
		if(!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ�"+srcFile+"������.");
		}
		if(!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile+"�����ļ�.");
		}
		BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(destFile));
		
		byte[] buf = new byte[8*1024];
		int c;
		bis.read();
		while((c=bis.read())!=-1) {
			bos.write(c);
			bos.flush();//ˢ�»�����������д�벻���ļ�����ȥ
		}
		System.out.println("���Ƴɹ���");
		bis.close();
		bos.close();
	}
	
	/**
	 * ���ֽڣ�������������ļ�����(����)
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	
	public static void copyFileByByte(File srcFile, File destFile) throws IOException {
		if(!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ�"+srcFile+"������.");
		}
		if(!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile+"�����ļ�.");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		int i;
		while((i=in.read())!=-1) {
			out.write(i);
//			out.flush();//û�л��� ���Բ���
		}
		System.out.println("���Ƴɹ���");
		in.close();
		out.close();
	}
}


