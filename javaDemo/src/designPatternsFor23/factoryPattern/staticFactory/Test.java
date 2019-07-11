package designPatternsFor23.factoryPattern.staticFactory;

public class Test {

	public static void main(String[] args) {
		Sender mailSender =SenderFactory.produceMail();
		mailSender.send();
		System.out.println("-------------------");
		Sender smsSender =SenderFactory.produceSms();
		smsSender.send();
	}

}
