package designPatternsFor23.observerPattern.demo3;

public class ConcreteWeatherSubject extends WeatherSubject{
	
	// ���� ���� ��ѩ
	//Ŀ������״̬
	private String weatherContent;
	
	@Override
	protected void notifyObservers() {
		//ѭ������ע��Ĺ۲���
//		����
//		1 С��Ů�� ֻ����� ���������Ԥ��
//		2 С������ ֻ����� ���������ѩ������Ԥ��
		for(Observer observer: observers) {
			if("����".equals(this.getWeatherContent())) {
				if("С����Ů����".equals(observer.getObserverName())) {
					observer.update(this);
				}
				if("С��������".equals(observer.getObserverName())) {
					observer.update(this);
				}
			}
			if("��ѩ".equals(this.getWeatherContent())) {
				if("С��������".equals(observer.getObserverName())) {
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
