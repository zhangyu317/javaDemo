package designPatternsFor23.singletonPattern.lazy;

public class Test {

	public static void main(String[] args) {
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		//��֤�Ƿ���ͬһʵ����
		System.out.println("�Ƿ���ͬһʵ����"+(singleton1==singleton2));

	}

}
