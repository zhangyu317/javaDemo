package designPatternsFor23.proxyPattern.dynamicProxy;

public class Service implements IService {

	@Override
	public void service() {
		System.out.println("被代理对象1   执行相关操作");
	}

}
