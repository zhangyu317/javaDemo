package designPatternsFor23.adapterPattern.adapterObject;

/**
 * 二项转三项的插座适配器
 * @author ZhangY
 *
 */
public class TwoPlugAdapter implements ThreePlugInterface {

	private GBTwoPlug plug;
	
	public TwoPlugAdapter(GBTwoPlug plug) {
		this.plug=plug;
	}
	
	@Override
	public void powerWithThree() {
		System.out.println("通过转换");
		plug.powerWithTwo();

	}

}
