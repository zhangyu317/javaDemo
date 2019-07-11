package designPatternsFor23.singletonPattern.hungry;

/**
 * 饿汉模式
 * 是线程安全的
 * @author ZhangY
 *
 */
public class Singleton {
	private Singleton() {
		
	}
	
	//因为在类加载的时候就创建实例， 所以称为饿汉模式
	private static Singleton instance = new Singleton();
	
	public static Singleton getInstance() {
		return instance;
	}
}
