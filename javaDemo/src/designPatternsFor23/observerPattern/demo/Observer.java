package designPatternsFor23.observerPattern.demo;
/**
 * ����һ���۲��߽ӿڣ�����һ�����µĽӿڸ���Щ��Ŀ�귢���ı��ʱ��֪ͨ�Ķ���
 * @author ZhangY
 *
 */
public interface Observer {
	public void update(WeatherSubject weatherSubject);
	public void update(String content);
}
