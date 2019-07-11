package designPatternsFor23.builderPattern;
/**
 * �����װ����Ա
 */
public class ConcreteBuilder extends Builder {
	
	Computer computer = new Computer();
	@Override
	public void buildCPU() {
		computer.Add("װCPU");

	}

	@Override
	public void buildMainBoard() {
		computer.Add("װ����");

	}

	@Override
	public void buildHD() {
		computer.Add("װӲ��");

	}

	@Override
	public Computer getComputer() {
		return computer;
	}

}
