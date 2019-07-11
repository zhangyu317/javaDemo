package designPatternsFor23.observerPattern.demo;
/**
 * Ŀ�������֪���۲����Ĺ۲��ߣ����ṩע�ᣨ��ӣ���ɾ���۲��ߵĽӿ�
 * @author ZhangY
 *
 */

import java.util.ArrayList;
import java.util.List;

public class WeatherSubject {
	//��������ע��Ĺ۲��߶���
	private List<Observer> observers = new ArrayList<Observer>();
	
	//attach detach notifyObservers
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	/**
	 * ɾ��������ָ��������������
	 */
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
	/**
	 * ֪ͨ�����Ѿ���������������
	 * ���ݶ�����ģ�ͣ�
	 */
	public void notifyObservers() {
		for(Observer observer: observers) {
			observer.update(this);
		}
	}
	/**
	 * ���贫�ݣ���ģ�ͣ�
	 */
	public void notifyObservers(String content) {
		for(Observer observer: observers) {
			observer.update(content);
		}
	}
	
	
}
