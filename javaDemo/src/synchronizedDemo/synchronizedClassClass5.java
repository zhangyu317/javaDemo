package synchronizedDemo;

/**
 * 
 * @author ZhangY
 *	类锁示例2：Class形式
 */
public class synchronizedClassClass5 implements Runnable{
	
	// instance1 instance2 这块和对象锁有所不同
	static synchronizedClassClass5 instance1 = new synchronizedClassClass5();
	static synchronizedClassClass5 instance2 = new synchronizedClassClass5();
	
	public static void main(String[] args) {
		Thread t1 =new Thread(instance1);
		Thread t2 =new Thread(instance2);
		t1.start();
		t2.start();
		while(t1.isAlive()||t2.isAlive()) {
			
		}
		System.out.println("finished");
	}
	
	@Override
	public void run() {
		method();
	}
	
	public void method() {
		synchronized (synchronizedClassClass5.class) {
			System.out.println("我是类锁的第二种形式： synchronized(*.class)。我叫"+ Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"运行结束");
		}
	}

}
