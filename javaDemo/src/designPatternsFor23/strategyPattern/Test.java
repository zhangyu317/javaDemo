package designPatternsFor23.strategyPattern;

public class Test {
	/**
	 * 使用 RedShapeDecorator 来装饰 Shape 对象。
	 */
	public static void main(String[] args) {
		Context context;

        context = new Context(new ConcreteStrategyA());
        context.contextInterface();

        context = new Context(new ConcreteStrategyB());
        context.contextInterface();
	}

}
