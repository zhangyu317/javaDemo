package IOdemo;

import java.io.File;
import java.io.IOException;

public class TestIOUtils {

	public static void main(String[] args) throws IOException {
//		IOUtils.printHex("D:\\javaIoFiles\\a.text\\hadoop");
//		IOUtils.printHexByByteArray("D:\\javaIoFiles\\a.text\\hadoop");
//		IOUtils.copyFile(new File("D:\\javaIoFiles\\a.text\\hadoop"), new File("D:\\javaIoFiles\\a.text\\hadoop2"));
//		IOUtils.copyFileByBuffer(new File("D:\\javaIoFiles\\a.text\\hadoop"), new File("D:\\javaIoFiles\\a.text\\hadoop3"));
		IOUtils.copyFileByByte(new File("D:\\javaIoFiles\\a.text\\hadoop"), new File("D:\\javaIoFiles\\a.text\\hadoop3"));
		
	}

}
