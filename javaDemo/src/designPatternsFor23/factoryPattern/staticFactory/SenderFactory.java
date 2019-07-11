package designPatternsFor23.factoryPattern.staticFactory;

public class SenderFactory {
	public static Sender produceMail() {
		return new MailSender();
	}
	
	public static Sender produceSms() {
		return new SmsSender();
	}
}
