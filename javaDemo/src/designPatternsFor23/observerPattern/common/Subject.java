package designPatternsFor23.observerPattern.common;
/**
 * Ŀ�������֪���۲����Ĺ۲��ߣ����ṩע�ᣨ��ӣ���ɾ���۲��ߵĽӿ�
 * @author ZhangY
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Subject {
	//��������ע��Ĺ۲��߶���
	private List<Observer> observers = new ArrayList<Observer>();
	
	//attach detach notifyObservers
	
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
	public void notifyObservers() {
		for(Observer observer: observers) {
			observer.update(this);
		}
	}
	
	
}
