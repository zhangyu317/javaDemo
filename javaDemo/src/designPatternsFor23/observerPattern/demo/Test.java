package designPatternsFor23.observerPattern.demo;

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
		observeGirl.setRemindThing("是我们的第一次约会，地点是街心公园，不见不散哦！");
		
		ConcreteObserve observeMum = new ConcreteObserve();
		observeMum.setObserverName("老妈");
		observeMum.setRemindThing("是一个购物的好日子，明天去天虹扫货！");
		
		//3 注册观察者
		weather.attach(observeGirl);
		weather.attach(observeMum);
		//4 目标发布天气
		weather.setWeatheSubjectState("明天天气晴朗，蓝天白云，气温28度");
	}
}
