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
 * ����TCPЭ���Socketͨ�ţ�ʵ���û���¼
 * ��������
 * @author ZhangY
 *
 */
public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket =new ServerSocket(8888);
			System.out.println("***�����������������ȴ��ͻ��˵�����**");
			Socket socket = serverSocket.accept();
			InputStream is=socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br= new BufferedReader(isr);
			String info = null;
			while((info = br.readLine())!=null) {
				System.out.println("���Ƿ��������ͻ���˵��"+ info);
			}
			socket.shutdownInput();
			
			OutputStream os=socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("��ӭ����");
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
