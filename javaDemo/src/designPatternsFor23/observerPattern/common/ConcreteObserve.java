package designPatternsFor23.observerPattern.common;

/**
 * 具体的观察者对象，实现更新的方法，使自身的状态和目标的状态保持一致
 * @author ZhangY
 *
 */
public class ConcreteObserve implements Observer{
	
	//观察者的状态
	public String observerState;
	
	/**
	 * 获取目标类的状态，同步到观察者的状态中
	 */
	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		observerState = ((ConcreteSubject)subject).getSubjectState();
		
	}

}
