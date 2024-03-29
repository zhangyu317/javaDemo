package designPatternsFor23.decoratorPattern;

public class Test {
	/**
	 * 使用 RedShapeDecorator 来装饰 Shape 对象。
	 */
	public static void main(String[] args) {
		Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
	}

}
