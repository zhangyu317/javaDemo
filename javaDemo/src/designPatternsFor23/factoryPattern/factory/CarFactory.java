package designPatternsFor23.factoryPattern.factory;

import java.util.Map;

/**
 * 汽车工厂
 * @author ZhangY
 *
 */
public class CarFactory {
	public Car getCar(String key) {
		if("audi".equalsIgnoreCase(key)) {
			return new AudiCar();
		}else if("byd".equalsIgnoreCase(key)) {
			return new BydCar();
		}
		return null;
	}
	
	//改进：根据类名称生成
	public Car getCarByClass(String className) {
		try {
			Car car = (Car) Class.forName(className).newInstance();
			return car;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//继续改进：根据key生成
	public Car getCarBykey(String key) {
		try {
			Map<String, String> map =new PropertiesReader().getProperties();
			Car car = (Car) Class.forName(map.get(key)).newInstance();
			return car;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
