package synchronizedDemo;

/**
 * 
 * @author ZhangY
 *	��ʧ������
 *
 *Ԥ�⣺i�Ľ��Ӧ����200000
 *����� i<200000
 *ԭ��
 *	count++, ������ȥ��һ��������ʵ���ϰ�����3������
 *	1 ��ȡcount
 *	2 ��count��1
 *	3 ��count��ֵд�뵽�ڴ���
 *
 */
public class DisappearRequest1 implements Runnable{
	
	static DisappearRequest1 instance = new DisappearRequest1();
	
	static int i = 0;
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 =new Thread(instance);
		Thread t2 =new Thread(instance);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}

	@Override
	public void run() {
//		synchronized(this) {	//�������� �������ʽ
		synchronized(DisappearRequest1.class) {	//������ �������ʽ
			for(int j=0;j<100000;j++) {
				i++;
			}
		}
	}
}
