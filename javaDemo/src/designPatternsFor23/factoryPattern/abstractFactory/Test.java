package designPatternsFor23.factoryPattern.abstractFactory;

public class Test {

	public static void main(String[] args) {
//		SenderFactory factory = new SenderFactory();
//		Sender mailSender =factory.produceMail();
//		mailSender.send();
//		System.out.println("-------------------");
//		Sender smsSender =factory.produceSms();
//		smsSender.send();
		
		Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.send();
	}

}
