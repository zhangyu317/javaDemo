package designPatternsFor23.observerPattern.demo3;
/**
 * ����һ���۲��߽ӿڣ�����һ�����µĽӿڸ���Щ��Ŀ�귢���ı��ʱ��֪ͨ�Ķ���
 * @author ZhangY
 *
 */
public interface Observer {
	//���µĽӿ�
	public void update(WeatherSubject subject);
	
	//���ù۲�������
	public void setObserverName(String observerName);
	
	//ȡ�ù۲�������
	public String getObserverName();
}
