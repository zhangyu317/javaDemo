package designPatternsFor23.proxyPattern.staticProxy;

public class Test {

	public static void main(String[] args) {
		IService service = new Service();
        //���뱻������Ķ���
        ProxyService proxyService = new ProxyService(service);
        proxyService.service();
	}

}
