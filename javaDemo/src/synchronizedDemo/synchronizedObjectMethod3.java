package synchronizedDemo;

/**
 * 
 * @author ZhangY
 *	对象锁示例1：代码块形式
 */
public class synchronizedObjectMethod3 implements Runnable{
	
	static synchronizedObjectMethod3 instance = new synchronizedObjectMethod3();
	Object lock1 =new Object();
	Object lock2 =new Object();
	
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
		synchronized (lock1){
			System.out.println("我是lock1。我叫"+ Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" lock1运行结束");
		}
		synchronized (lock2){
			System.out.println("我是lock2。我叫"+ Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" lock2运行结束");
		}
	}

}
