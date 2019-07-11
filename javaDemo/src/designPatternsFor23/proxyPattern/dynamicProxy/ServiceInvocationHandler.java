package designPatternsFor23.proxyPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ServiceInvocationHandler implements InvocationHandler{
	/**
     * ������Ķ���
     */
    private Object srcObject;
    
    public ServiceInvocationHandler(Object srcObject) {
        this.srcObject = srcObject;
    }
    
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("��ʼִ��"+method.getName()+"����");
        //ִ��ԭ�������ز�������������
        Object returnObj = method.invoke(srcObject,args);
        System.out.println(method.getName()+"����ִ�����");
        return returnObj;
	}

}
