package designPatternsFor23.factoryPattern.abstractFactory;

public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("This is sms sender...");
	}

}
