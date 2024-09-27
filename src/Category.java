import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Category {
    Connection conn;
    String transactionID;
    String categoryID;
    String categoryDetails;
    String userID;

    public Category(Connection conn, String transactionID, String categoryID, String categoryDetails, String userID){
        this.conn = conn;
        this.transactionID = transactionID;
        this.categoryID  = categoryID;
        this.categoryDetails = categoryDetails;
        this.userID = userID;
    }

    public static void createCategory(Connection conn, String categoryDetails, String userID){
        try {
            String query = String.format("INSERT INTO category(Category_details, user_id) VALUES ('%s', '%s'); ", categoryDetails, userID);
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Category Inserted!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void assignCategory(Connection conn, String transactionID, String categoryID, String userID){
        try{
            String query = String.format("UPDATE transaction SET category_id='%s' WHERE transaction_id='%s' AND user_id='%s'", categoryID, transactionID, userID);
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
