package designPatternsFor23.observerPattern.demo2Java;

import java.util.Observable;
import java.util.Observer;

/**
 * ����Ĺ۲��߶���ʵ�ָ��µķ�����ʹ�����״̬��Ŀ���״̬����һ��
 * @author ZhangY
 *
 */
public class ConcreteObserve implements Observer{
	
	//�۲��ߵ�����
	public String observerName;
	
	//�������ݵ�����������Ϣ��Ŀ���л�ȡ
	public String weatherContent;
	
	//���ѵ�����
	public String remindThing;
	
	

	@Override
	public void update(Observable o, Object arg) {
		// ��ģ��
		weatherContent = ((ConcreteWeatherSubject)o).getWeatheContent();
		System.out.println(observerName+"�յ���"+weatherContent+","+remindThing);
		// ��ģ��
		System.out.println(observerName+"�յ���"+arg+","+remindThing);
	}



	public String getObserverName() {
		return observerName;
	}

	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
	}

	public String getRemindThing() {
		return remindThing;
	}

	public void setRemindThing(String remindThing) {
		this.remindThing = remindThing;
	}
}
