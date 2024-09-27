import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    String name;
    String email;
    String password;

    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static String createUser(Connection conn, String name, String email, String password){
        try {
            String query = "INSERT INTO user_details (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            // Setting the parameters for the query
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);

            // Execute the query
            int affectedRows = statement.executeUpdate();

            // Check if the insertion was successful
            if (affectedRows > 0) {
                // Retrieve the generated keys
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    // Return the generated UUID (as a String)
                    return generatedKeys.getString(1);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Could not create user.";
    }


}
