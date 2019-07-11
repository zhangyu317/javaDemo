package designPatternsFor23.observerPattern.demo3;

import java.util.ArrayList;
import java.util.List;

public abstract class WeatherSubject {
	public List<Observer> observers = new ArrayList<Observer>();
	//1 attach 2 detach 3 abstract notifyObservers
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	/**
	 * 删除集合中指定的观察者
	 */
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
	/**
	 * 通知所有注册的观察者对象
	 */
	protected abstract void notifyObservers();
}
