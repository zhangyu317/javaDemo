package designPatternsFor23.adapterPattern.adapterObject;

/**
 * ����ת����Ĳ���������
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
		System.out.println("ͨ��ת��");
		plug.powerWithTwo();

	}

}
