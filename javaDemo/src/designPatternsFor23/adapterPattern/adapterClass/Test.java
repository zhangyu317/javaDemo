package designPatternsFor23.adapterPattern.adapterClass;

public class Test {
	public static void main(String[] args) {
		ThreePlugInterface threePlug = new TwoPlugAdapterExtends(); 
		NoteBookPc nBookPc = new NoteBookPc(threePlug);
		nBookPc.charge();
	}
}
