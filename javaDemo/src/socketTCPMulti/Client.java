package socketTCPMulti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 客户端
 */
public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8888); // 127.0.0.1
			// 
			OutputStream os=socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("用户名：admin2;密码：1234");
			pw.flush();
			socket.shutdownOutput();
			
			// 获取输入流，并读取服务器端的响应信息
			InputStream is=socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br= new BufferedReader(isr);
			String info = null;
			while((info = br.readLine())!=null) {
				System.out.println("我是客户器，服务器端说："+ info);
			}
			//关闭资源
			br.close();
			is.close();
			
			pw.close();
			os.close();
			//对于同一个socket，如果关闭了输出流(pw.close),则与该输出流关联的socket也会被关闭，所以一般不用关闭流，直接关闭socket即可
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
