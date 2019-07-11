package designPatternsFor23.factoryPattern.multFactory;

public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("This is sms sender...");
	}

}
