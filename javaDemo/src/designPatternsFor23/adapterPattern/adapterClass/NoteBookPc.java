package designPatternsFor23.adapterPattern.adapterClass;

/**
 * �ʼǱ���
 * @author ZhangY
 *
 */
public class NoteBookPc {
	private ThreePlugInterface plug;
	
	public NoteBookPc(ThreePlugInterface plug) {
		this.plug=plug;
	}
	
	//ʹ�ò������
	public void charge() {
		plug.powerWithThree();
	}
}
