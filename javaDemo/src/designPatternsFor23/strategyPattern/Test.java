package designPatternsFor23.strategyPattern;

public class Test {
	/**
	 * ʹ�� RedShapeDecorator ��װ�� Shape ����
	 */
	public static void main(String[] args) {
		Context context;

        context = new Context(new ConcreteStrategyA());
        context.contextInterface();

        context = new Context(new ConcreteStrategyB());
        context.contextInterface();
	}

}
