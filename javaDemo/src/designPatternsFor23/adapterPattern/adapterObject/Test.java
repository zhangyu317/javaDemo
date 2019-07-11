package designPatternsFor23.adapterPattern.adapterObject;

public class Test {
	public static void main(String[] args) {
		GBTwoPlug gbTwoPlug =new GBTwoPlug();
		ThreePlugInterface threePlug = new TwoPlugAdapter(gbTwoPlug);
		NoteBookPc nBookPc = new NoteBookPc(threePlug);
		nBookPc.charge();
	}
}
