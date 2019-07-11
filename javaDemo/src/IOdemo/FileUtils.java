package IOdemo;

import java.io.File;
/**
 * 列出File的一些常用操作 比如过滤、遍历等操作
 * @param args
 */


public class FileUtils {
	/**
	 * 列出指定目录下(包括其子目录)的所有文件
	 * @param dir
	 */
	static int count;
	public static void listDirectory(File dir) {
		if(!dir.exists()) {
			throw new IllegalArgumentException("目录"+dir+"不存在.");
		}
		if(!dir.isDirectory()) {
			throw new IllegalArgumentException(dir+"不是目录.");
		}
		//dir.list() 返回的是字符串数组 直接的子名称，不包含子目录下的内容 
		/*
		String[] fileNames = dir.list();
		for(String fileNameStr: fileNames) {
			System.out.println(dir + File.separator +fileNameStr);
		}*/
		//如果要遍历子目录下的内容 就需要构造成File对象做递归操作，File提供了直接返回File对象的
		File[] files = dir.listFiles();//返回的是直接子目录(文件)的对象
		if(files!=null && files.length>0) {
			for(File file: files) {
				if(file.isDirectory()) {
					//递归
					listDirectory(file);
				}else {
					count++;
					System.out.println(file);
				}
			}
		}
	}
}
