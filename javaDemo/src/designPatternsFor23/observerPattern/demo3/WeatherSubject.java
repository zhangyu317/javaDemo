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
	 * ɾ��������ָ���Ĺ۲���
	 */
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
	/**
	 * ֪ͨ����ע��Ĺ۲��߶���
	 */
	protected abstract void notifyObservers();
}
