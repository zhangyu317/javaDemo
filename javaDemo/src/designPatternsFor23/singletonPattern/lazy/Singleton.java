package designPatternsFor23.singletonPattern.lazy;

/**
 * 懒汉模式
 * 不是线程安全的，所以要加synchronized
 * 难点: volatile 原理???
 * @author ZhangY
 *
 */
public class Singleton {
	private Singleton () {
		
	}
	
//	private static Singleton instance;
	private static volatile Singleton instance=null;
	
	//用的时候才创建实例，所以称为懒汉模式
	public static synchronized Singleton getInstance() {
		if(instance==null) {
			instance = new Singleton();
		}
		return instance;
	}
}
