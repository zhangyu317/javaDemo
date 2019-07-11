package designPatternsFor23.observerPattern.common;
/**
 * 这是一个观察者接口，定义一个更新的接口给那些在目标发生改变的时候被通知的对象
 * @author ZhangY
 *
 */
public interface Observer {
	public void update(Subject subject);
}
