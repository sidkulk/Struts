package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class DatabaseOps {
	public static Connection conn;
	public static Statement stmt;
	public static PreparedStatement pstmt;
	public static ResultSet resultSet;
	private static final String URL = "jdbc:sqlite:webapp.db";

	private static DatabaseOps instance = new DatabaseOps();

	public static DatabaseOps getInstance() {
		return instance;
	}

	private DatabaseOps() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(URL);
			stmt = conn.createStatement();
			stmt.execute(dbInitialization.DatabaseInitialization.createTableQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception cnx) {
			cnx.printStackTrace();
		}
	}

	public String validateUser(String username, String password) {
		String query = "SELECT username, password FROM user WHERE username = ? AND password = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failure";
	}

	public User storeNewUser(String username, String password, String email) {
		String status = "userNotExists";
		String query = "INSERT INTO user(username, password, email) VALUES(?, ?, ?)";
		status = userAlreadyExists(username);

		if (status.equalsIgnoreCase("existed"))
			return null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.executeUpdate();
			status = "success";
			return new User(username, email, password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<User> getAllRegisteredUsers() {
		String query = "SELECT username, email, password FROM user";
		List<User> userList = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement(query);
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				userList.add(new User(resultSet.getString("username"), resultSet.getString("email"),
						resultSet.getString("password")));
			}
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
			return userList;
		}
	}

	public static String userAlreadyExists(String username) {
		String status = "notExisted";
		String query = "SELECT * FROM user WHERE username = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			resultSet = pstmt.executeQuery();
			boolean getResultSet = resultSet.next();
			if (getResultSet == true)
				status = "existed";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static void closeAllConnections() {
		try {
			stmt.close();
			pstmt.close();
			conn.close();
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
