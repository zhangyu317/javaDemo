package designPatternsFor23.adapterPattern.adapterObject;

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
