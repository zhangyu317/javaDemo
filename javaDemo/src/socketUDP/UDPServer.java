package socketUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *  网络提供两种服务： TCP UDP(例如 视频 语音)
 *  
 *  TCP/IP协议是传输层协议，主要解决数据如何在网络中传输，而HTTP是应用层协议，主要解决如何包装数据。
 *  关于TCP/IP和HTTP协议的关系，网络有一段比较容易理解的介绍：“我们在传输数据时，可以只使用（传输层）TCP/IP协议，
 *  但是那样的话，如果没有应用层，便无法识别数据内容，如果想要使传输的数据有意义，
 *  则必须使用到应用层协议，应用层协议有很多，比如HTTP、FTP、TELNET等，也可以自己定义应用层协议。
 *  WEB使用HTTP协议作应用层协议，以封装HTTP 文本信息，然后使用TCP/IP做传输层协议将它发到网络上。”
 *  
 *  术语TCP/IP代表传输控制协议/网际协议，指的是一系列协议。
 *  “IP”代表网际协议，TCP和UDP使用该协议从一个网络传送数据包到另一个网络。
 *  把IP想像成一种高速公路，它允许其它协议在上面行驶并找到到其它电脑的出口。
 *  TCP和UDP是高速公路上的“卡车”，它们携带的货物就是像HTTP，文件传输协议FTP这样的协议等。 
 */

/**
 *     7 应用层          HTTP/FTP/SMTP/Telnet       TFTP
 *     6 表示层                              |                   |
 *     5 会话层                              |                   |
 *     4 传输层                           TCP                 UDP
 *     3 网络层                                                     IP
 *     2 数据链路层
 *     1 物理层
 */

/**
 *7	应用层	例如HTTP、SMTP、SNMP、FTP、Telnet、SIP、SSH、NFS、RTSP、XMPP、Whois、ENRP
 *6	表示层	例如XDR、ASN.1、SMB、AFP、NCP
 *5	会话层	例如ASAP、TLS、SSH、ISO 8327 / CCITT X.225、RPC、NetBIOS、ASP、Winsock、BSD sockets
 *4	传输层	例如TCP、UDP、RTP、SCTP、SPX、ATP、IL
 *3	网络层	例如IP、ICMP、IGMP、IPX、BGP、OSPF、RIP、IGRP、EIGRP、ARP、RARP、 X.25
 *2	数据链路层	例如以太网、令牌环、HDLC、帧中继、ISDN、ATM、IEEE 802.11、FDDI、PPP
 *1	物理层	例如线路、无线电、光纤、信鸽
 */

/**
 * UDP编程
 * UDP协议(用户数据报协议) 是无连接、不可靠的、无序的。 有点事速度快
 * UDP协议以数据报作为数据传输的载体
 * 进行数据传输时，首先需要将要传输的数据定义成数据报(Datagram)，在数据报中指明数据
 * 所要到达的目的地Socket(主机地址和端口号)，然后再将数据报发送出去
 * 
 * 相关操作类
 * DatagramPacket： 表示数据报包
 * DatagramSocket： 表示端到端通信的类
 * 
 * 服务器端实现步骤：
 * 		1 创建DatagramSocket，指定端口号
 * 		2 创建DatagramPacket，用来接收客户端发送的数据
 * 		3 接收客户端发送的数据信息
 * 		4 读取数据
 * 客户端端实现步骤：
 * 		1 定义发送信息。(服务器的地址 端口号 内容)
 * 		2 创建DatagramPacket，包含简要发送的信息
 * 		3 创建DatagramSocket，实现数据的发送
 * 		4 发送数据
 */

/**
 * 服务器端，实现基于UDP的用户登录
 * @author ZhangY
 *
 */
public class UDPServer {
	public static void main(String[] args) throws IOException {
		//1 创建服务器端DatagramSocket，指定端口
		DatagramSocket socket = new DatagramSocket(8800);
		//2 创建数据报，用于接收客户端发送的数据
		byte[] data =new byte[1024];//创建字节数组，指定接收的数据包的大小
		DatagramPacket packet= new DatagramPacket(data, data.length);
		//3 接收客户端发送的数据
		System.out.println("*****服务器端已经启动，等待客户端发送数据！");
		socket.receive(packet);//次方法在接收到数据报之间会一直阻塞
		//4 读取数据
		String info= new String(data, 0, data.length);
		System.out.println("我是服务器，客户端说："+info);
		
		/**
		 * 向客户端响应数据
		 */
		//1 定义服务器的地址、端口号、数据
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 ="欢迎您！".getBytes();
		//2 创建数据报，包含响应的数据信息
		DatagramPacket packet2= new DatagramPacket(data2, 0, data2.length, address, port);
		//3 向客户端发送数据
		socket.send(packet2);
		//4 关闭资源
		socket.close();
		
	}
}





