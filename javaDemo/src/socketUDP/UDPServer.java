package socketUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *  �����ṩ���ַ��� TCP UDP(���� ��Ƶ ����)
 *  
 *  TCP/IPЭ���Ǵ����Э�飬��Ҫ�����������������д��䣬��HTTP��Ӧ�ò�Э�飬��Ҫ�����ΰ�װ���ݡ�
 *  ����TCP/IP��HTTPЭ��Ĺ�ϵ��������һ�αȽ��������Ľ��ܣ��������ڴ�������ʱ������ֻʹ�ã�����㣩TCP/IPЭ�飬
 *  ���������Ļ������û��Ӧ�ò㣬���޷�ʶ���������ݣ������Ҫʹ��������������壬
 *  �����ʹ�õ�Ӧ�ò�Э�飬Ӧ�ò�Э���кܶ࣬����HTTP��FTP��TELNET�ȣ�Ҳ�����Լ�����Ӧ�ò�Э�顣
 *  WEBʹ��HTTPЭ����Ӧ�ò�Э�飬�Է�װHTTP �ı���Ϣ��Ȼ��ʹ��TCP/IP�������Э�齫�����������ϡ���
 *  
 *  ����TCP/IP���������Э��/����Э�飬ָ����һϵ��Э�顣
 *  ��IP����������Э�飬TCP��UDPʹ�ø�Э���һ�����紫�����ݰ�����һ�����硣
 *  ��IP�����һ�ָ��ٹ�·������������Э����������ʻ���ҵ����������Եĳ��ڡ�
 *  TCP��UDP�Ǹ��ٹ�·�ϵġ�������������Я���Ļ��������HTTP���ļ�����Э��FTP������Э��ȡ� 
 */

/**
 *     7 Ӧ�ò�          HTTP/FTP/SMTP/Telnet       TFTP
 *     6 ��ʾ��                              |                   |
 *     5 �Ự��                              |                   |
 *     4 �����                           TCP                 UDP
 *     3 �����                                                     IP
 *     2 ������·��
 *     1 �����
 */

/**
 *7	Ӧ�ò�	����HTTP��SMTP��SNMP��FTP��Telnet��SIP��SSH��NFS��RTSP��XMPP��Whois��ENRP
 *6	��ʾ��	����XDR��ASN.1��SMB��AFP��NCP
 *5	�Ự��	����ASAP��TLS��SSH��ISO 8327 / CCITT X.225��RPC��NetBIOS��ASP��Winsock��BSD sockets
 *4	�����	����TCP��UDP��RTP��SCTP��SPX��ATP��IL
 *3	�����	����IP��ICMP��IGMP��IPX��BGP��OSPF��RIP��IGRP��EIGRP��ARP��RARP�� X.25
 *2	������·��	������̫�������ƻ���HDLC��֡�м̡�ISDN��ATM��IEEE 802.11��FDDI��PPP
 *1	�����	������·�����ߵ硢���ˡ��Ÿ�
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

/**
 * �������ˣ�ʵ�ֻ���UDP���û���¼
 * @author ZhangY
 *
 */
public class UDPServer {
	public static void main(String[] args) throws IOException {
		//1 ������������DatagramSocket��ָ���˿�
		DatagramSocket socket = new DatagramSocket(8800);
		//2 �������ݱ������ڽ��տͻ��˷��͵�����
		byte[] data =new byte[1024];//�����ֽ����飬ָ�����յ����ݰ��Ĵ�С
		DatagramPacket packet= new DatagramPacket(data, data.length);
		//3 ���տͻ��˷��͵�����
		System.out.println("*****���������Ѿ��������ȴ��ͻ��˷������ݣ�");
		socket.receive(packet);//�η����ڽ��յ����ݱ�֮���һֱ����
		//4 ��ȡ����
		String info= new String(data, 0, data.length);
		System.out.println("���Ƿ��������ͻ���˵��"+info);
		
		/**
		 * ��ͻ�����Ӧ����
		 */
		//1 ����������ĵ�ַ���˿ںš�����
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 ="��ӭ����".getBytes();
		//2 �������ݱ���������Ӧ��������Ϣ
		DatagramPacket packet2= new DatagramPacket(data2, 0, data2.length, address, port);
		//3 ��ͻ��˷�������
		socket.send(packet2);
		//4 �ر���Դ
		socket.close();
		
	}
}





