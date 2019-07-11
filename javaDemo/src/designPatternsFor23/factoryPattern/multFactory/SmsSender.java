package designPatternsFor23.factoryPattern.multFactory;

public class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("This is mail sender...");
	}

}
