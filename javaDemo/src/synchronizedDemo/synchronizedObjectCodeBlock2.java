package synchronizedDemo;

/**
 * 
 * @author ZhangY
 *	������ʾ��1���������ʽ
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
			System.out.println("���Ƕ������Ĵ������ʽ���ҽ�"+ Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"���н���");
		}
	}

}
