package designPatternsFor23.singletonPattern.lazy;

/**
 * ����ģʽ
 * �����̰߳�ȫ�ģ�����Ҫ��synchronized
 * �ѵ�: volatile ԭ��???
 * @author ZhangY
 *
 */
public class Singleton {
	private Singleton () {
		
	}
	
//	private static Singleton instance;
	private static volatile Singleton instance=null;
	
	//�õ�ʱ��Ŵ���ʵ�������Գ�Ϊ����ģʽ
	public static synchronized Singleton getInstance() {
		if(instance==null) {
			instance = new Singleton();
		}
		return instance;
	}
}
