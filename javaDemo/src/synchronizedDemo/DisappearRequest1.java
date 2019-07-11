package synchronizedDemo;

/**
 * 
 * @author ZhangY
 *	消失的请求
 *
 *预测：i的结果应该是200000
 *结果： i<200000
 *原因：
 *	count++, 它看上去是一个操作，实际上包含了3个动作
 *	1 读取count
 *	2 将count加1
 *	3 将count的值写入到内存中
 *
 */
public class DisappearRequest1 implements Runnable{
	
	static DisappearRequest1 instance = new DisappearRequest1();
	
	static int i = 0;
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 =new Thread(instance);
		Thread t2 =new Thread(instance);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}

	@Override
	public void run() {
//		synchronized(this) {	//对象锁： 代码块形式
		synchronized(DisappearRequest1.class) {	//类锁： 代码块形式
			for(int j=0;j<100000;j++) {
				i++;
			}
		}
	}
}
