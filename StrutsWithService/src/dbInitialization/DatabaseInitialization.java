package dbInitialization;

public interface DatabaseInitialization {
	public static final String USER_TABLE = "user";

	public static final String createTableQuery = "CREATE TABLE IF NOT EXISTS " + USER_TABLE + " ("
			+ "u_id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT NOT NULL, password TEXT NOT NULL, email TEXT UNIQUE NOT NULL)";
}
