package designPatternsFor23.observerPattern.demo3;

public class Test {
	public static void main(String[] args) {
		//1 创建目标
//		ConcreteWeatherSubject concreteWeatherSubject = new ConcreteWeatherSubject();
//		concreteWeatherSubject.setWeatheSubjectState("天气晴朗，适合出游。。");
//		
//		ConcreteObserve concreteObserve = new ConcreteObserve();
//		concreteObserve.setObserverName("小明");
//		concreteObserve.setRemindThing("aa");
//		concreteWeatherSubject.attach(concreteObserve);
//		concreteWeatherSubject.notifyObservers();
		
		//1 创建目标
		ConcreteWeatherSubject weather = new ConcreteWeatherSubject();
		//2 创建观察者
		ConcreteObserve observeGirl = new ConcreteObserve();
		observeGirl.setObserverName("小明的女朋友");
		observeGirl.setRemindThing("下雨了，安静的在家呆着吧！");
		
		ConcreteObserve observeMum = new ConcreteObserve();
		observeMum.setObserverName("小明的老妈");
		observeMum.setRemindThing("不管下雨还是下雪，我都不出门！");
		
		//3 注册观察者
		weather.attach(observeGirl);
		weather.attach(observeMum);
		//4 目标发布天气
		weather.setWeatherContent("下雪");
		System.out.println("----------------------------");
		weather.setWeatherContent("下雨");
	}
}
