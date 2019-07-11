package designPatternsFor23.observerPattern.common;

/**
 * ����Ĺ۲��߶���ʵ�ָ��µķ�����ʹ�����״̬��Ŀ���״̬����һ��
 * @author ZhangY
 *
 */
public class ConcreteObserve implements Observer{
	
	//�۲��ߵ�״̬
	public String observerState;
	
	/**
	 * ��ȡĿ�����״̬��ͬ�����۲��ߵ�״̬��
	 */
	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		observerState = ((ConcreteSubject)subject).getSubjectState();
		
	}

}
