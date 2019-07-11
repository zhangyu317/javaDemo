package socketTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的Socket通信，实现用户登录
 * 服务器端
 * @author ZhangY
 *
 */
public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket =new ServerSocket(8888);
			System.out.println("***服务器即将启动，等待客户端的连接**");
			Socket socket = serverSocket.accept();
			InputStream is=socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br= new BufferedReader(isr);
			String info = null;
			while((info = br.readLine())!=null) {
				System.out.println("我是服务器，客户端说："+ info);
			}
			socket.shutdownInput();
			
			OutputStream os=socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("欢迎您！");
			pw.flush();
			socket.shutdownOutput();
			pw.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
