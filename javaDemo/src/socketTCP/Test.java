package socketTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) throws Exception {
//		testAddressMethod();
//		testURLMethod();
		//ʹ��url����ȡ��ҳ����
		readContentUseUrl();
	}
	
	public static void testAddressMethod() throws UnknownHostException {
		InetAddress address= InetAddress.getLocalHost();
		System.out.println("�������:"+address.getHostName());
		System.out.println("IP��ַ:"+address.getHostAddress());
		//��ȡ�ֽ�������ʽ��IP��ַ
		byte[] bytes= address.getAddress();
		System.out.println("�ֽ�������ʽ��IP:"+Arrays.toString(bytes));
		
		System.out.println("______________________________");
//		InetAddress address2= InetAddress.getByName("ZhangY-PC");
		InetAddress address2= InetAddress.getByName("192.168.0.102");
		System.out.println("�������:"+address2.getHostName());
		System.out.println("IP��ַ:"+address2.getHostAddress());
		byte[] bytes2= address.getAddress();
		System.out.println("�ֽ�������ʽ��IP:"+Arrays.toString(bytes));
		
		byte a =(byte)192;
		System.out.println(a);
	}
	
	public static void testURLMethod() throws MalformedURLException {
		URL url1 = new URL("http://www.imooc.com");
		//#����ê�㣨��ת��λ�ã�
		URL url2 = new URL(url1,"/index.html?username=tom#test");
		System.out.println("Э�飺"+url2.getProtocol());
		System.out.println("������"+url2.getHost());
		//��� δָ���˿ںţ���ʹ��Ĭ�϶˿ںţ���ʱ�� getPost()��������ֵ��-1
		System.out.println("�˿ڣ�"+url2.getPort());
		System.out.println("�ļ�·����"+url2.getPath());
		System.out.println("�ļ����ƣ�"+url2.getFile());
		System.out.println("�ļ����·����"+url2.getRef());
		System.out.println("��ѯ�ַ�����"+url2.getQuery());
		
	}
	
	/**
	 * ʹ��url����ȡ��ҳ����
	 * @throws IOException 
	 */
	public static void readContentUseUrl() throws IOException {
		URL url = new URL("http://www.baidu.com");
		//ͨ��URL��openStream()������ȡURL��������ʾ����Դ���ֽ�������
		InputStream is= url.openStream();
		//���ֽ�������ת��Ϊ�ַ�������
		InputStreamReader isr = new InputStreamReader(is,"utf-8");
		//Ϊ�ַ���������ӻ��壬��߶�ȡЧ��
		BufferedReader br = new BufferedReader(isr);
		//��ȡ���ݣ�һ�ζ�һ��
		String data = br.readLine();
		while(data != null) {
			System.out.println(data);
			data = br.readLine();
		}
		br.close();
		isr.close();
		is.close();
	}
	
	
	/**
	 * �½ڣ�3.1
	 * Socketͨ��
	 * TCPЭ��ʱ�������ӡ��ɿ��ġ�����ġ����ֽ����ķ�ʽ��������
	 * ����TCPЭ��ʵ������ͨ�ŵ���
	 * 		�ͻ��˵�Socket��
	 * 		�������˵�ServerSocket��
	 * ����ͨ�Ź���
	 * 		1 �����ȥ����һ��ServerSocket, ����Ӧ�Ķ˿ڲ�����ָ���Ķ˿ڽ��м������ȴ��ͻ��˵�����
	 * 		2 ���ڿͻ��˴���Socket������������˷�������
	 * 		3 ��ʱ���������յ������ҽ��ܿͻ��˵�������Ϣ����������socket
	 * 		4 ����InputStream--OutputStream  OutPutStream--InputStream �������ݵĽ��������͡����ա��Լ����ݵ���Ӧ
	 * 		5 ͨ�������Ҫ�ر����˵�socket������ͨѶ�ĶϿ�
	 * Socketͨ��ʵ�ֲ���
	 * 		1 ����ServerSocket��Socket
	 * 		2 �����ӵ�Socket������/�����
	 * 		3 ����Э���Socket���ж�д����
	 * 		4 �ر�������������ر�Scoket
	 * 
	 * ��ظ���
	 * TCP��������IP��ַ���������ϵĶ˿ں���ΪTCP���ӵĶ˵㣬���ֶ˵�ͽ����׽��֣�socket�����ڡ�
	 * �׽����ã�IP��ַ���˿ںţ���ʾ��
	 * 
	 * ����
	 * �������ˣ�
	 * 		1 ����ServerSocket���󣬰󶨼����˿�
	 * 		2 ͨ��accept()���������ͻ�������
	 * 		3 ���ӽ�����ͨ����������ȡ�ͻ��˷��͵�������Ϣ
	 * 		4 ͨ���������ͻ��˷�����Ӧ��Ϣ
	 * 		5 �ر������Դ
	 * �ͻ��ˣ�
	 * 		1 ����Socket����ָ����Ҫ���ӵķ������ĵ�ַ�Ͷ˿ں�
	 * 		2 ���ӽ�����ͨ���������ȡ�������˷��͵�������Ϣ
	 * 		4 ͨ����������ȡ��������Ӧ����Ϣ
	 * 		5 �ر������Դ
	 */
	
	/**
	 * ���̷߳�����
	 * Ӧ�ö��߳���ʵ�ַ��������ͻ���֮���ͨ��
	 * ��������
	 * 		1 �������˴���ServerSocket,ѭ������accept()�ȴ��ͻ��˵�����
	 * 		2 �ͻ��˴���һ��Socket������ͷ�����������
	 * 		3 �������˽��տͻ������󣬴���socket��ÿͻ��˽���ר������
	 * 		4 �������ӵ�����socket��һ���������߳��϶Ի�
	 * 		5�������˼����ȴ��µ�����
	 */
	
	
	/**
	 * UDP���
	 * UDPЭ��(�û����ݱ�Э��) �������ӡ����ɿ��ġ�����ġ� �е����ٶȿ�
	 * UDPЭ�������ݱ���Ϊ���ݴ��������
	 * �������ݴ���ʱ��������Ҫ��Ҫ��������ݶ�������ݱ�(Datagram)�������ݱ���ָ������
	 * ��Ҫ�����Ŀ�ĵ�Socket(������ַ�Ͷ˿ں�)��Ȼ���ٽ����ݱ����ͳ�ȥ
	 * 
	 * ��ز�����
	 * DatagramPacket�� ��ʾ���ݱ���
	 * DatagramSocket�� ��ʾ�˵���ͨ�ŵ���
	 * 
	 * ��������ʵ�ֲ��裺
	 * 		1 ����DatagramSocket��ָ���˿ں�
	 * 		2 ����DatagramPacket���������տͻ��˷��͵�����
	 * 		3 ���տͻ��˷��͵�������Ϣ
	 * 		4 ��ȡ����
	 * �ͻ��˶�ʵ�ֲ��裺
	 * 		1 ���巢����Ϣ��(�������ĵ�ַ �˿ں� ����)
	 * 		2 ����DatagramPacket��������Ҫ���͵���Ϣ
	 * 		3 ����DatagramSocket��ʵ�����ݵķ���
	 * 		4 ��������
	 */
	
	
}
