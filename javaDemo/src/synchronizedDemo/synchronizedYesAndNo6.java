package synchronizedDemo;

/**
 * 
 * @author ZhangY
 *	ͬʱ����ͬ���������ͬ������
 *���ۣ� ��ͬ����������Ӱ��
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
		System.out.println("���Ǽ������ķ������ҽ�" + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "���н���");
	}
	
	public void method2() {
		System.out.println("����û�м����ķ������ҽ�" + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "���н���");
	}
}
