package socketTCPMulti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * ���������̴߳�����
 * @author ZhangY
 *
 */
public class ServerThread extends Thread{
	//�ͱ��߳���ص�Socket
	Socket socket=null;
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	//�߳�ִ�еĲ�������Ӧ�ͻ��˵�����
	public void run() {
		InputStream is =null;
		InputStreamReader isr =null;
		BufferedReader br =null;
		OutputStream os =null;
		PrintWriter pw =null;
		try {
			//��ȡ������������ȡ�ͻ�����Ϣ
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println("���Ƿ��������ͻ���˵��" + info);
			}
			socket.shutdownInput();
			// ��ȡ���������Ӧ�ͻ��˵�����
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("��ӭ����");
			pw.flush();// ����flush()���������
			socket.shutdownOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//�ر���Դ
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
