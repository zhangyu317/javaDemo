package synchronizedDemo;

/**
 * 
 * @author ZhangY
 *	ͬʱ����ͬ���������ͬ������
 *���ۣ� ������ͬ����������������һ�������������ǿ���ͬʱ����
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
		System.out.println("���Ǿ�̬�����ķ���1���ҽ�" + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "���н���");
	}
	
	public synchronized void method2() {
		System.out.println("���ǷǾ�̬�����ķ���2���ҽ�" + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "���н���");
	}
}
