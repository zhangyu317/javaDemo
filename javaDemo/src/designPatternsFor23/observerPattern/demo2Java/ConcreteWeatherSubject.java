package designPatternsFor23.observerPattern.demo2Java;

import java.util.Observable;

/**
 * �����Ŀ�����,������й�״̬���뵽��Ӧ�Ĺ۲��߶�����
 * @author ZhangY
 *
 */
public class ConcreteWeatherSubject extends Observable{
	
	//��ȡ������������Ϣ
	private String WeatherContent;

	public String getWeatheContent() {
		return WeatherContent;
	}

	public void setWeatheSubjectState(String WeatherContent) {
		this.WeatherContent = WeatherContent;
		//�������ˣ�˵�����������ˣ�֪ͨ���еĶ�����
		//ע�⣺��֪֮ͨǰ������java��Observableģʽʱ��������仰������
		this.setChanged();
		//��ģ��
//		this.notifyObservers();
		//��ģ��
		this.notifyObservers(WeatherContent);
	}
}
