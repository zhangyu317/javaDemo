package synchronizedDemo;

/**
 * 
 * @author ZhangY
 *	同时访问同步方法与非同步方法
 *结论： 非同步方法不受影响
 */
public class synchronizedYesAndNo6 implements Runnable{
	
	static synchronizedYesAndNo6 instance = new synchronizedYesAndNo6();
	
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
	
	public synchronized void method1() {
		System.out.println("我是加了锁的方法，我叫" + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "运行结束");
	}
	
	public void method2() {
		System.out.println("我是没有加锁的方法，我叫" + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "运行结束");
	}
}
