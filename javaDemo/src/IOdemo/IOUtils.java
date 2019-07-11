package IOdemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 读取指定文件内容,按照16进制输出到控制台。
 * 并且每输出10个byte换行
 * @author ZhangY
 *
 *
 *
 */
public class IOUtils {
	public static void printHex(String fileName) throws IOException {
		//把文件作为字节流进行读操作
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int i =1;
		while ((b = in.read())!= -1) {
			if (b<= 0xf) {
				//单位数前面补零
				System.out.print("0");
			}
			//将整形b转换为16进制表示的字符串
			System.out.print(Integer.toHexString(b)+ " ");
			//换行
			if(i++%10 == 0) {
				System.out.println();
			}
		}
		in.close();
	}
	
	public static void printHexByByteArray(String fileName) throws IOException{
		FileInputStream in = new FileInputStream(fileName);
		byte[] buf = new byte[20 * 1024];
		//从in中批量读取字节，放入到buf这个字节数组中，
		//从第0个位置开始放，最多放buf.length个
		//*返回的是读到的字节的个数（因为有可能没有把这个字节数组读满）
		
		//方法一：
		
		/*int bytes = in.read(buf, 0, buf.length);
		int j = 1;
		for(int i=0;i<bytes;i++) {
			//将整形b转换为16进制表示的字符串
			System.out.print(Integer.toHexString(buf[i] & 0xff)+ " ");
			//换行
			if(j++%10 == 0) {
				System.out.println();
			}
		}*/
		
		
		//方法二：
		int bytes = 0;
		int j = 1;
		while((bytes = in.read(buf, 0, buf.length))!=-1) {
			for(int i =0;i<bytes;i++) {
				System.out.print(Integer.toHexString(buf[i] & 0xff)+ " ");// 0xff：byte类型为8位，int是32位。为了避免数据转换错误，通过& 0xff将高24位清零
				//换行
				if(j++%10 == 0) {
					System.out.println();
				}
			}
		}
		in.close();
	}
	
	
	/**
	 * 文件拷贝，字节批量读取(最快)
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException {
		if(!srcFile.exists()) {
			throw new IllegalArgumentException("文件"+srcFile+"不存在.");
		}
		if(!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile+"不是文件.");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] buf = new byte[8*1024];
		int i;
		while((i=in.read(buf,0,buf.length))!=-1) {
			out.write(buf, 0, i);
			out.flush();//最好加上
		}
		System.out.println("复制成功！");
		in.close();
		out.close();
	}
	
	/**
	 * 利用带缓冲的字节流 进行文件的拷贝
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByBuffer(File srcFile, File destFile) throws IOException {
		if(!srcFile.exists()) {
			throw new IllegalArgumentException("文件"+srcFile+"不存在.");
		}
		if(!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile+"不是文件.");
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
			bos.flush();//刷新缓冲区，否则写入不到文件当中去
		}
		System.out.println("复制成功！");
		bis.close();
		bos.close();
	}
	
	/**
	 * 单字节，不带缓冲进行文件拷贝(最慢)
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	
	public static void copyFileByByte(File srcFile, File destFile) throws IOException {
		if(!srcFile.exists()) {
			throw new IllegalArgumentException("文件"+srcFile+"不存在.");
		}
		if(!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile+"不是文件.");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		int i;
		while((i=in.read())!=-1) {
			out.write(i);
//			out.flush();//没有缓冲 可以不加
		}
		System.out.println("复制成功！");
		in.close();
		out.close();
	}
}


