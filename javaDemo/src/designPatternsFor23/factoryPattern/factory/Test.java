package designPatternsFor23.factoryPattern.factory;
/**
 * 工厂方法模式： 
	1. 工厂方法模式分为三种：普通工厂模式，就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建。 
	2. 多个工厂方法模式，是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象。 
	3. 静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
 * @author ZhangY
 *
 */
public class Test {

	public static void main(String[] args) {
//		Car audiCar= new AudiCar();
//		audiCar.run();
//		
//		Car bydCar = new BydCar();
//		bydCar.run();
		
		CarFactory factory = new CarFactory();
		Car car=factory.getCar("audi");
		car.run();
		
		Car car2=factory.getCarByClass("designPatternsFor23.factoryPattern.factory.BydCar");
		car2.run();
		
		Car car3=factory.getCarBykey("audi");
		car3.run();
		
		Car car4=factory.getCarBykey("bwm");
		car4.run();
	}

}
