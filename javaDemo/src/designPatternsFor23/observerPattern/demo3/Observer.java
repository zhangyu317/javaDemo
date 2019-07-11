package designPatternsFor23.observerPattern.demo3;
/**
 * 这是一个观察者接口，定义一个更新的接口给那些在目标发生改变的时候被通知的对象
 * @author ZhangY
 *
 */
public interface Observer {
	//更新的接口
	public void update(WeatherSubject subject);
	
	//设置观察者名称
	public void setObserverName(String observerName);
	
	//取得观察者名称
	public String getObserverName();
}
