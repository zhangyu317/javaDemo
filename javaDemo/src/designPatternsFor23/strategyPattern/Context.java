package designPatternsFor23.strategyPattern;
/**
 * �����ģ�ά��һ���Բ�������������
 */
public class Context {
	Strategy strategy;
	public Context(Strategy strategy) {
        this.strategy = strategy;
    }
	public void contextInterface(){
        strategy.AlgorithmInterface();
    }
}
