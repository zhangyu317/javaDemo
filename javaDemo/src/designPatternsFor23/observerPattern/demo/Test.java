package designPatternsFor23.observerPattern.demo;

public class Test {
	public static void main(String[] args) {
		//1 ����Ŀ��
//		ConcreteWeatherSubject concreteWeatherSubject = new ConcreteWeatherSubject();
//		concreteWeatherSubject.setWeatheSubjectState("�������ʣ��ʺϳ��Ρ���");
//		
//		ConcreteObserve concreteObserve = new ConcreteObserve();
//		concreteObserve.setObserverName("С��");
//		concreteObserve.setRemindThing("aa");
//		concreteWeatherSubject.attach(concreteObserve);
//		concreteWeatherSubject.notifyObservers();
		
		//1 ����Ŀ��
		ConcreteWeatherSubject weather = new ConcreteWeatherSubject();
		//2 �����۲���
		ConcreteObserve observeGirl = new ConcreteObserve();
		observeGirl.setObserverName("С����Ů����");
		observeGirl.setRemindThing("�����ǵĵ�һ��Լ�ᣬ�ص��ǽ��Ĺ�԰��������ɢŶ��");
		
		ConcreteObserve observeMum = new ConcreteObserve();
		observeMum.setObserverName("����");
		observeMum.setRemindThing("��һ������ĺ����ӣ�����ȥ���ɨ����");
		
		//3 ע��۲���
		weather.attach(observeGirl);
		weather.attach(observeMum);
		//4 Ŀ�귢������
		weather.setWeatheSubjectState("�����������ʣ�������ƣ�����28��");
	}
}
