package designPatternsFor23.builderPattern;

public class Director {
	public void Construct(Builder builder) {
        builder.buildCPU();
        builder.buildMainBoard();
        builder.buildHD();
    }
}
