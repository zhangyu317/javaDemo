package designPatternsFor23.observerPattern.demo;

/**
 * 具体的观察者对象，实现更新的方法，使自身的状态和目标的状态保持一致
 * @author ZhangY
 *
 */
public class ConcreteObserve implements Observer{
	
	//观察者的名字
	public String observerName;
	
	//天气内容的情况，这个消息从目标中获取
	public String weatherContent;
	
	//提醒的内容
	public String remindThing;
	
	/**
	 * 获取目标类的状态，同步到观察者的状态中
	 */

	@Override
	public void update(WeatherSubject weatherSubject) {
		weatherContent = ((ConcreteWeatherSubject)weatherSubject).getWeatheContent();
		System.out.println(observerName+"收到了"+weatherContent+","+remindThing);
	}
	
	/**
	 * 
	 * 按需传递
	 */
	@Override
	public void update(String content) {
		weatherContent = content;
		System.out.println(observerName+"收到了"+weatherContent+","+remindThing);
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
