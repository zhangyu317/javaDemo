package designPatternsFor23.factoryPattern.multFactory;

public class Test {

	public static void main(String[] args) {
		SenderFactory factory = new SenderFactory();
		Sender mailSender =factory.produceMail();
		mailSender.send();
		System.out.println("-------------------");
		Sender smsSender =factory.produceSms();
		smsSender.send();
	}

}
