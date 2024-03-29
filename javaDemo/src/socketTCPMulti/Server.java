package socketTCPMulti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
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
			//1 创建一个服务器端的socket,即ServerSocket，指定绑定的端口，并监听次端口
			ServerSocket serverSocket =new ServerSocket(8888);
			Socket socket = null;
			//记录客户端的数量
			int count = 0;
			System.out.println("***服务器即将启动，等待客户端的连接**");
			//循环监听等待客户端的连接
			while(true) {
				//2调用accept()方法开始监听，等待客户端的连接
				socket = serverSocket.accept();
				//创建一个新的线程
				ServerThread serverThread = new ServerThread(socket);
				//启动线程
				//设置线程的优先级，范围是[1,10],默认是5
				//未设置优先级可能导致运行时速度非常慢，可降低优先级。
				serverThread.setPriority(4);
				serverThread.start();
				count++;
				System.out.println("客户端的数量为："+count);
				InetAddress address = socket.getInetAddress();
				System.out.println("当前客户端的IP："+address.getHostAddress());
			}
//			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
