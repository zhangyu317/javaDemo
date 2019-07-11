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
 * ����TCPЭ���Socketͨ�ţ�ʵ���û���¼
 * ��������
 * @author ZhangY
 *
 */
public class Server {
	public static void main(String[] args) {
		try {
			//1 ����һ���������˵�socket,��ServerSocket��ָ���󶨵Ķ˿ڣ��������ζ˿�
			ServerSocket serverSocket =new ServerSocket(8888);
			Socket socket = null;
			//��¼�ͻ��˵�����
			int count = 0;
			System.out.println("***�����������������ȴ��ͻ��˵�����**");
			//ѭ�������ȴ��ͻ��˵�����
			while(true) {
				//2����accept()������ʼ�������ȴ��ͻ��˵�����
				socket = serverSocket.accept();
				//����һ���µ��߳�
				ServerThread serverThread = new ServerThread(socket);
				//�����߳�
				//�����̵߳����ȼ�����Χ��[1,10],Ĭ����5
				//δ�������ȼ����ܵ�������ʱ�ٶȷǳ������ɽ������ȼ���
				serverThread.setPriority(4);
				serverThread.start();
				count++;
				System.out.println("�ͻ��˵�����Ϊ��"+count);
				InetAddress address = socket.getInetAddress();
				System.out.println("��ǰ�ͻ��˵�IP��"+address.getHostAddress());
			}
//			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
