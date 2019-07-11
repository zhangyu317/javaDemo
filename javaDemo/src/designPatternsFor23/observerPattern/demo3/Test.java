package designPatternsFor23.observerPattern.demo3;

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
		observeGirl.setRemindThing("�����ˣ��������ڼҴ��Űɣ�");
		
		ConcreteObserve observeMum = new ConcreteObserve();
		observeMum.setObserverName("С��������");
		observeMum.setRemindThing("�������껹����ѩ���Ҷ������ţ�");
		
		//3 ע��۲���
		weather.attach(observeGirl);
		weather.attach(observeMum);
		//4 Ŀ�귢������
		weather.setWeatherContent("��ѩ");
		System.out.println("----------------------------");
		weather.setWeatherContent("����");
	}
}
