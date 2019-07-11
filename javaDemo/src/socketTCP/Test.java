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
		//使用url，读取网页内容
		readContentUseUrl();
	}
	
	public static void testAddressMethod() throws UnknownHostException {
		InetAddress address= InetAddress.getLocalHost();
		System.out.println("计算机名:"+address.getHostName());
		System.out.println("IP地址:"+address.getHostAddress());
		//获取字节数组形式的IP地址
		byte[] bytes= address.getAddress();
		System.out.println("字节数组形式的IP:"+Arrays.toString(bytes));
		
		System.out.println("______________________________");
//		InetAddress address2= InetAddress.getByName("ZhangY-PC");
		InetAddress address2= InetAddress.getByName("192.168.0.102");
		System.out.println("计算机名:"+address2.getHostName());
		System.out.println("IP地址:"+address2.getHostAddress());
		byte[] bytes2= address.getAddress();
		System.out.println("字节数组形式的IP:"+Arrays.toString(bytes));
		
		byte a =(byte)192;
		System.out.println(a);
	}
	
	public static void testURLMethod() throws MalformedURLException {
		URL url1 = new URL("http://www.imooc.com");
		//#代表锚点（跳转的位置）
		URL url2 = new URL(url1,"/index.html?username=tom#test");
		System.out.println("协议："+url2.getProtocol());
		System.out.println("主机："+url2.getHost());
		//如果 未指定端口号，则使用默认端口号，此时的 getPost()方法返回值是-1
		System.out.println("端口："+url2.getPort());
		System.out.println("文件路径："+url2.getPath());
		System.out.println("文件名称："+url2.getFile());
		System.out.println("文件相对路径："+url2.getRef());
		System.out.println("查询字符串："+url2.getQuery());
		
	}
	
	/**
	 * 使用url，读取网页内容
	 * @throws IOException 
	 */
	public static void readContentUseUrl() throws IOException {
		URL url = new URL("http://www.baidu.com");
		//通过URL的openStream()方法获取URL对象所表示的资源的字节输入流
		InputStream is= url.openStream();
		//将字节输入流转换为字符输入流
		InputStreamReader isr = new InputStreamReader(is,"utf-8");
		//为字符输入流添加缓冲，提高读取效率
		BufferedReader br = new BufferedReader(isr);
		//读取数据，一次读一行
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
	 * 章节：3.1
	 * Socket通信
	 * TCP协议时面向连接、可靠的、有序的、以字节流的方式发送数据
	 * 基于TCP协议实现网络通信的类
	 * 		客户端的Socket类
	 * 		服务器端的ServerSocket类
	 * 具体通信过程
	 * 		1 服务端去建立一个ServerSocket, 绑定相应的端口并且在指定的端口进行监听，等待客户端的连接
	 * 		2 当在客户端创建Socket并且向服务器端发送请求
	 * 		3 此时，服务器收到请求并且接受客户端的请求信息，创建连接socket
	 * 		4 利用InputStream--OutputStream  OutPutStream--InputStream 进行数据的交换、发送、接收、以及数据的相应
	 * 		5 通信完后，需要关闭两端的socket，进行通讯的断开
	 * Socket通信实现步骤
	 * 		1 创建ServerSocket和Socket
	 * 		2 打开连接到Socket的输入/输出流
	 * 		3 按照协议对Socket进行读写操作
	 * 		4 关闭输入输出流、关闭Scoket
	 * 
	 * 相关概念
	 * TCP用主机的IP地址加上主机上的端口号作为TCP连接的端点，这种端点就叫做套接字（socket）或插口。
	 * 套接字用（IP地址：端口号）表示。
	 * 
	 * 案例
	 * 服务器端：
	 * 		1 创建ServerSocket对象，绑定监听端口
	 * 		2 通过accept()方法监听客户端请求
	 * 		3 连接建立后，通过输入流读取客户端发送的请求信息
	 * 		4 通过输出流向客户端发送响应信息
	 * 		5 关闭相关资源
	 * 客户端：
	 * 		1 创建Socket对象，指明需要连接的服务器的地址和端口号
	 * 		2 连接建立后，通过输出流读取服务器端发送的请求信息
	 * 		4 通过输入流获取服务器响应的信息
	 * 		5 关闭相关资源
	 */
	
	/**
	 * 多线程服务器
	 * 应用多线程来实现服务器与多客户端之间的通信
	 * 基本步骤
	 * 		1 服务器端创建ServerSocket,循环调用accept()等待客户端的连接
	 * 		2 客户端创建一个Socket并请求和服务器端连接
	 * 		3 服务器端接收客户端请求，创建socket与该客户端建立专线连接
	 * 		4 建立连接的两个socket在一个单独的线程上对话
	 * 		5服务器端继续等待新的连接
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
	
	
}
