package designPatternsFor23.observerPattern.demo;
/**
 * 具体的目标对象,负责把有关状态存入到相应的观察者对象中
 * @author ZhangY
 *
 */
public class ConcreteWeatherSubject extends WeatherSubject{
	
	//获取天气的内容信息
	private String WeatherContent;

	public String getWeatheContent() {
		return WeatherContent;
	}

	public void setWeatheSubjectState(String WeatherContent) {
		this.WeatherContent = WeatherContent;
		//内容有了，说明天气更新了，通知所有的订阅人
		//拉模型
//		this.notifyObservers();
		//推模型
		this.notifyObservers(WeatherContent);
	}
}
