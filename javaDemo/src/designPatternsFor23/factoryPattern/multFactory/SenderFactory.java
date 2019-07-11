package designPatternsFor23.factoryPattern.multFactory;

public class SenderFactory {
	public Sender produceMail() {
		return new MailSender();
	}
	
	public Sender produceSms() {
		return new SmsSender();
	}
}
