package designPatternsFor23.decoratorPattern;
/**
 * ����ʵ���� Shape �ӿڵĳ���װ���ࡣ
 */
abstract class ShapeDecorator implements Shape{
	protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
