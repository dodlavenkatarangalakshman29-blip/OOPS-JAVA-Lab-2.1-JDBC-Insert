import java.sql.*;

public class JDBCInsert {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), email VARCHAR(100))";
        String insertSQL = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement createStmt = conn.prepareStatement(createTableSQL);
             PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {

            createStmt.execute();

            insertStmt.setString(1, "johndoe");
            insertStmt.setString(2, "johndoe@example.com");
            insertStmt.executeUpdate();

            insertStmt.setString(1, "janedoe");
            insertStmt.setString(2, "janedoe@example.com");
            insertStmt.executeUpdate();

            System.out.println("Data inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
