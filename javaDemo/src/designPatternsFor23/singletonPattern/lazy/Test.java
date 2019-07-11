package designPatternsFor23.singletonPattern.lazy;

public class Test {

	public static void main(String[] args) {
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		//验证是否是同一实例？
		System.out.println("是否是同一实例："+(singleton1==singleton2));

	}

}
