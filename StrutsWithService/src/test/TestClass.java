package test;

import java.util.List;

import model.User;
import service.DatabaseOps;

//import model.User;

public class TestClass {
	public static void main(String[] args) {
		try {
			List<User> registeredUsers =  DatabaseOps.getAllRegisteredUsers();
			
			registeredUsers.forEach(users -> System.out.println(users));
//
//			service.DatabaseOps.storeNewUser(new User("testUser4", "test4@gmail.com", "test123"));
//			service.DatabaseOps.storeNewUser(new User("testUser5", "test5@gmail.com", "test123"));
//			service.DatabaseOps.storeNewUser(new User("testUser6", "test6@gmail.com", "test123"));
//
//			System.out.println("is user test12 present?: " + service.DatabaseOps.validateUser("test12", "test123"));
//			System.out
//					.println("is user testUser2 present?: " + service.DatabaseOps.validateUser("testUser2", "test123"));
//			System.out.println(
//					"is user testUser22 present?: " + service.DatabaseOps.validateUser("testUser22", "test123"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			service.DatabaseOps.closeAllConnections();
			System.out.println("All connections closed");
		}
	}
}
