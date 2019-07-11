package designPatternsFor23.adapterPattern.adapterObject;

/**
 * 笔记本类
 * @author ZhangY
 *
 */
public class NoteBookPc {
	private ThreePlugInterface plug;
	
	public NoteBookPc(ThreePlugInterface plug) {
		this.plug=plug;
	}
	
	//使用插座充电
	public void charge() {
		plug.powerWithThree();
	}
}
