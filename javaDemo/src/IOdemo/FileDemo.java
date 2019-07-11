package IOdemo;

import java.io.File;
import java.io.IOException;

public class FileDemo {
	/**
	 * ���÷�����
	 * 
	 * �ж��ļ������ļ����Ƿ����
	 * file.exists()
	 * 
	 * �ж��Ƿ���Ŀ¼(��Ŀ¼����true,����Ŀ¼��Ŀ¼�����ڷ���false)
	 * file.isDirectory()
	 * 
	 * �ж��Ƿ����ļ�
	 * file.isFile()
	 * 
	 * �����ļ����ļ���
	 * file.mkdir() //ֻ����һ��
	 * file.mkdirs(); //�����༶
	 * 
	 * �����ļ�(����IO�쳣)
	 * file.createNewFile();
	 * 
	 * ɾ���ļ����ļ���
	 * file.delete();
	 * 
	 * //����API
		System.out.println(file);//file.toString()������
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getParentFile());
	 */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		createFile("D:\\javaIoFiles\\a.text");

	}
	
	/**
	 * �����ļ�
	 * @throws IOException 
	 */
	public static void createFile(String pathname) throws IOException {
		//pathname������˫б�ܣ�Ҳ�����÷�б�ܣ�Ҳ�����÷ָ���File.separator
		File file = new File(pathname);
		//�ж��ļ������ļ����Ƿ����
		System.out.println(file.exists());
		if(!file.exists()) {
			//�����ļ����ļ���
			file.mkdirs();
		}else {
			//ɾ���ļ����ļ���
			//
		}
		
		//�ж��Ƿ���Ŀ¼(��Ŀ¼����true,����Ŀ¼��Ŀ¼�����ڷ���false)
		System.out.println(file.isDirectory());
		//�Ƿ����ļ�
		System.out.println(file.isFile());
		
		//����API
		System.out.println(file);//file.toString()������
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getParentFile());
	}

}
