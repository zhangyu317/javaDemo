package designPatternsFor23.observerPattern.demo;
/**
 * �����Ŀ�����,������й�״̬���뵽��Ӧ�Ĺ۲��߶�����
 * @author ZhangY
 *
 */
public class ConcreteWeatherSubject extends WeatherSubject{
	
	//��ȡ������������Ϣ
	private String WeatherContent;

	public String getWeatheContent() {
		return WeatherContent;
	}

	public void setWeatheSubjectState(String WeatherContent) {
		this.WeatherContent = WeatherContent;
		//�������ˣ�˵�����������ˣ�֪ͨ���еĶ�����
		//��ģ��
//		this.notifyObservers();
		//��ģ��
		this.notifyObservers(WeatherContent);
	}
}
