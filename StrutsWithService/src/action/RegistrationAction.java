package action;

import com.opensymphony.xwork2.ActionSupport;

import model.User;
import service.DatabaseOps;

@SuppressWarnings("serial")
public class RegistrationAction extends ActionSupport {
	private String username; // unique field
	private String email;
	private String password;
	private User newUser;

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		String status = "failure";
		DatabaseOps databaseOps = DatabaseOps.getInstance();
		setNewUser(databaseOps.storeNewUser(username, password, email));
		if (getNewUser() != null)
			return "success";
		return status;
	}

}
