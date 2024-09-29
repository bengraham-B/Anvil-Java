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

    public static void showAllUserCategories(Connection conn, String userID){
        try{
            String query = String.format("SELECT category_details FROM category WHERE user_id='%s'", userID);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while(resultSet.next()){
                System.out.println("[Category]:  " + resultSet.getString("category_details"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //TODO Make a function which shows transactions which do not have a category
}
