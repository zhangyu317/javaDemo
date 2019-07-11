package designPatternsFor23.factoryPattern.factory;
/**
 * ��������ģʽ�� 
	1. ��������ģʽ��Ϊ���֣���ͨ����ģʽ�����ǽ���һ�������࣬��ʵ����ͬһ�ӿڵ�һЩ�����ʵ���Ĵ����� 
	2. �����������ģʽ���Ƕ���ͨ��������ģʽ�ĸĽ�������ͨ��������ģʽ�У�������ݵ��ַ�������������ȷ�������󣬶������������ģʽ���ṩ��������������ֱ𴴽����� 
	3. ��̬��������ģʽ��������Ķ����������ģʽ��ķ�����Ϊ��̬�ģ�����Ҫ����ʵ����ֱ�ӵ��ü��ɡ�
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
