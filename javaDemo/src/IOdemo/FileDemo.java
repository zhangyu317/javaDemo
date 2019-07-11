package IOdemo;

import java.io.File;
import java.io.IOException;

public class FileDemo {
	/**
	 * 常用方法：
	 * 
	 * 判断文件或者文件夹是否存在
	 * file.exists()
	 * 
	 * 判断是否是目录(是目录返回true,不是目录或目录不存在返回false)
	 * file.isDirectory()
	 * 
	 * 判断是否是文件
	 * file.isFile()
	 * 
	 * 创建文件或文件夹
	 * file.mkdir() //只创建一级
	 * file.mkdirs(); //创建多级
	 * 
	 * 创建文件(会有IO异常)
	 * file.createNewFile();
	 * 
	 * 删除文件或文件夹
	 * file.delete();
	 * 
	 * //常用API
		System.out.println(file);//file.toString()的内容
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
	 * 创建文件
	 * @throws IOException 
	 */
	public static void createFile(String pathname) throws IOException {
		//pathname可以用双斜杠，也可以用反斜杠，也可以用分隔符File.separator
		File file = new File(pathname);
		//判断文件或者文件夹是否存在
		System.out.println(file.exists());
		if(!file.exists()) {
			//创建文件或文件夹
			file.mkdirs();
		}else {
			//删除文件或文件夹
			//
		}
		
		//判断是否是目录(是目录返回true,不是目录或目录不存在返回false)
		System.out.println(file.isDirectory());
		//是否是文件
		System.out.println(file.isFile());
		
		//常用API
		System.out.println(file);//file.toString()的内容
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getParentFile());
	}

}
