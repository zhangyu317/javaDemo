package designPatternsFor23.proxyPattern.staticProxy;
/**
 * ������
 */
public class ProxyService implements IService {
	/**
     * ���б�������������
     */
    private IService service;
    
    /**
     * Ĭ�ϴ���Service��
     */
    public ProxyService() {
        this.service = new Service();
    }
    /**
     * Ҳ���Դ���ʵ����ͬ�ӿڵ�������
     * @param service
     */
    public ProxyService(IService service) {
        this.service = service;
    }
    
	@Override
	public void service() {
		System.out.println("��ʼִ��service()����");
        service.service();
        System.out.println("service()����ִ�����");
	}

}
