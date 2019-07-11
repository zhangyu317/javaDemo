package synchronizedDemo;

/**
 * 
 * @author ZhangY
 *	同时访问同步方法与非同步方法
 *结论： 这两个同步方法的锁对象不是一个对象，所以他们可以同时运行
 */
public class synchronizedStaticAndNormal8 implements Runnable{
	
	static synchronizedStaticAndNormal8 instance = new synchronizedStaticAndNormal8();
	
	public static void main(String[] args) {
		Thread t1 =new Thread(instance);
		Thread t2 =new Thread(instance);
		t1.start();
		t2.start();
		while(t1.isAlive()||t2.isAlive()) {
			
		}
		System.out.println("finished");
	}
	
	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("Thread-0")) {
			method1();
		}else {
			method2();
		}
	}
	
	public static synchronized void method1() {
		System.out.println("我是静态加锁的方法1，我叫" + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "运行结束");
	}
	
	public synchronized void method2() {
		System.out.println("我是非静态加锁的方法2，我叫" + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "运行结束");
	}
}
