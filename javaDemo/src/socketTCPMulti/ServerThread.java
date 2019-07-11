package socketTCPMulti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 服务器端线程处理类
 * @author ZhangY
 *
 */
public class ServerThread extends Thread{
	//和本线程相关的Socket
	Socket socket=null;
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	//线程执行的操作，响应客户端的请求
	public void run() {
		InputStream is =null;
		InputStreamReader isr =null;
		BufferedReader br =null;
		OutputStream os =null;
		PrintWriter pw =null;
		try {
			//获取输入流，并读取客户端信息
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println("我是服务器，客户端说：" + info);
			}
			socket.shutdownInput();
			// 获取输出流，响应客户端的请求
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("欢迎您！");
			pw.flush();// 调用flush()将缓冲输出
			socket.shutdownOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//关闭资源
				if(pw!=null) {
					pw.close();
				}
				if(pw!=null) {
					os.close();
				}
				if(os!=null) {
					br.close();
				}
				if(br!=null) {
					isr.close();
				}
				if(isr!=null) {
					is.close();
				}
				if(socket!=null) {
					socket.close();
				}
				//serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
