package designPatternsFor23.observerPattern.demo3;

public class ConcreteWeatherSubject extends WeatherSubject{
	
	// 晴天 下雨 下雪
	//目标对象的状态
	private String weatherContent;
	
	@Override
	protected void notifyObservers() {
		//循环所有注册的观察者
//		需求：
//		1 小明女友 只想接收 下雨的天气预报
//		2 小明妈妈 只想就收 下雨或者下雪的天气预报
		for(Observer observer: observers) {
			if("下雨".equals(this.getWeatherContent())) {
				if("小明的女朋友".equals(observer.getObserverName())) {
					observer.update(this);
				}
				if("小明的老妈".equals(observer.getObserverName())) {
					observer.update(this);
				}
			}
			if("下雪".equals(this.getWeatherContent())) {
				if("小明的老妈".equals(observer.getObserverName())) {
					observer.update(this);
				}
			}
		}
		
	}

	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
		this.notifyObservers();
	}
}
