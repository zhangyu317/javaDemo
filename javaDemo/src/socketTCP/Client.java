package socketTCP;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * �ͻ���
 */
public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8888); // 127.0.0.1
			// 
			OutputStream os=socket.getOutputStream();
			//���Ҫ���ݶ������ 
			//ObjectOutputStream oos =new ObjectOutputStream(os);
			//oos.writeObject(����); (�������л�)
			//���Ҫ�����ļ���
			//BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(fileTmp));
			PrintWriter pw = new PrintWriter(os);
			pw.write("�û�����admin;���룺123");
			pw.flush();
			socket.shutdownOutput();
			
			// ��ȡ������������ȡ�������˵���Ӧ��Ϣ
			InputStream is=socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br= new BufferedReader(isr);
			String info = null;
			while((info = br.readLine())!=null) {
				System.out.println("���ǿͻ�������������˵��"+ info);
			}
			//�ر���Դ
			br.close();
			is.close();
			
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
