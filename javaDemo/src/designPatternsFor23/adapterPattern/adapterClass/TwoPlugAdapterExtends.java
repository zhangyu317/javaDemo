package designPatternsFor23.adapterPattern.adapterClass;

/**
 * ���ü̳з�ʽ�Ĳ���������
 * @author ZhangY
 *
 */
public class TwoPlugAdapterExtends extends GBTwoPlug implements ThreePlugInterface {

	@Override
	public void powerWithThree() {
		System.out.println("�����̳�������");
		this.powerWithTwo();
	}

}
