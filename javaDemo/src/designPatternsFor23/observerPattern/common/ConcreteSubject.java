package designPatternsFor23.observerPattern.common;
/**
 * �����Ŀ�����,������й�״̬���뵽��Ӧ�Ĺ۲��߶�����
 * @author ZhangY
 *
 */
public class ConcreteSubject extends Subject{
	
	//Ŀ������״̬
	private String subjectState;

	public String getSubjectState() {
		return subjectState;
	}

	public void setSubjectState(String subjectState) {
		this.subjectState = subjectState;
		this.notifyObservers();
	}
}
