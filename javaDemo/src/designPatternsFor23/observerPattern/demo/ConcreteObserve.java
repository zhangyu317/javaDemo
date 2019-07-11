package designPatternsFor23.observerPattern.demo;

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
	
	/**
	 * ��ȡĿ�����״̬��ͬ�����۲��ߵ�״̬��
	 */

	@Override
	public void update(WeatherSubject weatherSubject) {
		weatherContent = ((ConcreteWeatherSubject)weatherSubject).getWeatheContent();
		System.out.println(observerName+"�յ���"+weatherContent+","+remindThing);
	}
	
	/**
	 * 
	 * ���贫��
	 */
	@Override
	public void update(String content) {
		weatherContent = content;
		System.out.println(observerName+"�յ���"+weatherContent+","+remindThing);
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
