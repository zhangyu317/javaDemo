package designPatternsFor23.factoryPattern.abstractFactory;

public class SendSmsFactory implements Provider {

	@Override
	public Sender produce() {
		return new SmsSender();
	}

}
