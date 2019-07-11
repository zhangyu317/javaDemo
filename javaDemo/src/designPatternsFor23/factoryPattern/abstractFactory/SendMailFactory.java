package designPatternsFor23.factoryPattern.abstractFactory;

public class SendMailFactory implements Provider {

	@Override
	public Sender produce() {
		return new MailSender();
	}

}
