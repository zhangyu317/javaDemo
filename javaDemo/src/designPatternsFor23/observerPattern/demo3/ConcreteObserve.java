package designPatternsFor23.observerPattern.demo3;

public class ConcreteObserve implements Observer{
	//�۲��ߵ�����
	public String observerName;
	
	//�������ݵ�����������Ϣ��Ŀ���л�ȡ
	public String weatherContent;
	
	//���ѵ�����
	public String remindThing;
	@Override
	public void update(WeatherSubject subject) {
		weatherContent = ((ConcreteWeatherSubject)subject).getWeatherContent();
		System.out.println(observerName+"�յ���"+weatherContent+","+remindThing);
	}

	@Override
	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

	@Override
	public String getObserverName() {
		return observerName;
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
