package synchronizedDemo;

/**
 * 
 * @author ZhangY
 *	对象锁示例1：代码块形式
 */
public class synchronizedObjectCodeBlock2 implements Runnable{
	
	static synchronizedObjectCodeBlock2 instance = new synchronizedObjectCodeBlock2();
	
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
		synchronized (this){
			System.out.println("我是对象锁的代码块形式。我叫"+ Thread.currentThread().getName());
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
