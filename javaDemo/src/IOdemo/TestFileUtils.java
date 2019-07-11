package IOdemo;

import java.io.File;

public class TestFileUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileUtils.listDirectory(new File("D:\\javaIoFiles\\a.text"));
		System.out.println(FileUtils.count);
	}

}
