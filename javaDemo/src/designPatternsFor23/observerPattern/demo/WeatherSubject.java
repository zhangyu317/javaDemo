package designPatternsFor23.observerPattern.demo;
/**
 * 目标对象，它知道观察它的观察者，并提供注册（添加）和删除观察者的接口
 * @author ZhangY
 *
 */

import java.util.ArrayList;
import java.util.List;

public class WeatherSubject {
	//用来保存注册的观察者对象
	private List<Observer> observers = new ArrayList<Observer>();
	
	//attach detach notifyObservers
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	/**
	 * 删除集合中指定订阅天气的人
	 */
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
	/**
	 * 通知所有已经订阅了天气的人
	 * 传递对象（拉模型）
	 */
	public void notifyObservers() {
		for(Observer observer: observers) {
			observer.update(this);
		}
	}
	/**
	 * 按需传递（推模型）
	 */
	public void notifyObservers(String content) {
		for(Observer observer: observers) {
			observer.update(content);
		}
	}
	
	
}
