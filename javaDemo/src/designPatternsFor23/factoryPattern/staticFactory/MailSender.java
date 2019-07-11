package designPatternsFor23.factoryPattern.staticFactory;

public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("This is sms sender...");
	}

}
