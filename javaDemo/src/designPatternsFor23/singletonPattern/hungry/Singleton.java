package designPatternsFor23.singletonPattern.hungry;

/**
 * ����ģʽ
 * ���̰߳�ȫ��
 * @author ZhangY
 *
 */
public class Singleton {
	private Singleton() {
		
	}
	
	//��Ϊ������ص�ʱ��ʹ���ʵ���� ���Գ�Ϊ����ģʽ
	private static Singleton instance = new Singleton();
	
	public static Singleton getInstance() {
		return instance;
	}
}
