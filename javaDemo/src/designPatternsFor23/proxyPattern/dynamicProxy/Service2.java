package designPatternsFor23.proxyPattern.dynamicProxy;

public class Service2 implements IService {

	@Override
	public void service() {
		System.out.println("被代理对象2   执行相关操作");
	}

}
