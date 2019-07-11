package synchronizedDemo;

/**
 * 
 * @author ZhangY
 *	����ʾ��1��static��ʽ
 */
public class synchronizedClassStatic4 implements Runnable{
	
	// instance1 instance2 ���Ͷ�����������ͬ
	static synchronizedClassStatic4 instance1 = new synchronizedClassStatic4();
	static synchronizedClassStatic4 instance2 = new synchronizedClassStatic4();
	
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
	
	public static synchronized void method() {
		System.out.println("���������ĵ�һ����ʽ�� static��ʽ���ҽ�"+ Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"���н���");
	}

}
