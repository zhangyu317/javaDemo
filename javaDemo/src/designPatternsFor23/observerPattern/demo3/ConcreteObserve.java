package designPatternsFor23.observerPattern.demo3;

public class ConcreteObserve implements Observer{
	//观察者的名字
	public String observerName;
	
	//天气内容的情况，这个消息从目标中获取
	public String weatherContent;
	
	//提醒的内容
	public String remindThing;
	@Override
	public void update(WeatherSubject subject) {
		weatherContent = ((ConcreteWeatherSubject)subject).getWeatherContent();
		System.out.println(observerName+"收到了"+weatherContent+","+remindThing);
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
