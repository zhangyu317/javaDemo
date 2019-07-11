package designPatternsFor23.builderPattern;

public abstract class Builder {
	 /**
     * ��һ����װCPU
     */
	public abstract void buildCPU();
	/**
     * �ڶ�����װ����
     */
    public abstract void buildMainBoard();

    /**
     * ��������װӲ��
     */
    public abstract void buildHD();

    /**
     * �����װ�õĵ���
     * @return
     */
    public abstract Computer getComputer();
}
