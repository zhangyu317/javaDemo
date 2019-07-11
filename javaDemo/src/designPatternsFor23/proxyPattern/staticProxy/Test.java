package designPatternsFor23.proxyPattern.staticProxy;

public class Test {

	public static void main(String[] args) {
		IService service = new Service();
        //传入被代理类的对象
        ProxyService proxyService = new ProxyService(service);
        proxyService.service();
	}

}
