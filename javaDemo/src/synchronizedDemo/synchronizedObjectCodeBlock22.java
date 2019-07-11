package synchronizedDemo;

/**
 * 
 * @author ZhangY
 *	������ʾ��2����������ʽ
 */
public class synchronizedObjectCodeBlock22 implements Runnable{
	
	static synchronizedObjectCodeBlock22 instance = new synchronizedObjectCodeBlock22();
	
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
		method();
	}
	
	public synchronized void method() {
		System.out.println("���Ƕ������ķ������η���ʽ���ҽ�" + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "���н���");
	}

}
