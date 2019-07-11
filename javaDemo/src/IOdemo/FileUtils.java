package IOdemo;

import java.io.File;
/**
 * �г�File��һЩ���ò��� ������ˡ������Ȳ���
 * @param args
 */


public class FileUtils {
	/**
	 * �г�ָ��Ŀ¼��(��������Ŀ¼)�������ļ�
	 * @param dir
	 */
	static int count;
	public static void listDirectory(File dir) {
		if(!dir.exists()) {
			throw new IllegalArgumentException("Ŀ¼"+dir+"������.");
		}
		if(!dir.isDirectory()) {
			throw new IllegalArgumentException(dir+"����Ŀ¼.");
		}
		//dir.list() ���ص����ַ������� ֱ�ӵ������ƣ���������Ŀ¼�µ����� 
		/*
		String[] fileNames = dir.list();
		for(String fileNameStr: fileNames) {
			System.out.println(dir + File.separator +fileNameStr);
		}*/
		//���Ҫ������Ŀ¼�µ����� ����Ҫ�����File�������ݹ������File�ṩ��ֱ�ӷ���File�����
		File[] files = dir.listFiles();//���ص���ֱ����Ŀ¼(�ļ�)�Ķ���
		if(files!=null && files.length>0) {
			for(File file: files) {
				if(file.isDirectory()) {
					//�ݹ�
					listDirectory(file);
				}else {
					count++;
					System.out.println(file);
				}
			}
		}
	}
}
