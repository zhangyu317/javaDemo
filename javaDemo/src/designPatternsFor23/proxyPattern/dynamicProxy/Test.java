package designPatternsFor23.proxyPattern.dynamicProxy;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		IService service = new Service();
        Class<? extends IService> clazz = service.getClass();

        IService proxyService = (IService) Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(), new ServiceInvocationHandler(service));
        proxyService.service();
        
        System.out.println("------------------------------");
        
        IService service2 = new Service2();
        Class<? extends IService> clazz2 = service2.getClass();
        
        IService proxyService2 = (IService) Proxy.newProxyInstance(clazz2.getClassLoader(),
        		clazz2.getInterfaces(), new ServiceInvocationHandler(service2));
        proxyService2.service();
	}

}
