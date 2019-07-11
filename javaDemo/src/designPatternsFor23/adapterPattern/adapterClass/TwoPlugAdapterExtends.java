package designPatternsFor23.adapterPattern.adapterClass;

/**
 * ²ÉÓÃ¼Ì³Ğ·½Ê½µÄ²å×ùÊÊÅäÆ÷
 * @author ZhangY
 *
 */
public class TwoPlugAdapterExtends extends GBTwoPlug implements ThreePlugInterface {

	@Override
	public void powerWithThree() {
		System.out.println("½èÖú¼Ì³ĞÊÊÅäÆ÷");
		this.powerWithTwo();
	}

}
