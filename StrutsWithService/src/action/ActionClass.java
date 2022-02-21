package action;

import com.opensymphony.xwork2.Action;

import service.RandomService;

public class ActionClass implements Action {
	private String randomMessage;

	public String getRandomMessage() {
		return randomMessage;
	}

	public void setRandomMessage(String randomMessage) {
		this.randomMessage = randomMessage;
	}

	@Override
	public String execute() {
		setRandomMessage(new RandomService().getSomeMessage());
		return "success";
	}
}