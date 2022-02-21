package action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import model.User;
import service.DatabaseOps;

public class ShowAllUserAction implements Action {
	private List<User> userList;
	private static final String FAILURE = "failure";

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public String execute() {
		setUserList(DatabaseOps.getAllRegisteredUsers());
		if (getUserList() == null)
			return FAILURE;
		return Action.SUCCESS;
	}

}
