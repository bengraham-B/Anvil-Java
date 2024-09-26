import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.Date;
import java.time.LocalDate;

//

public class Transaction {
    String details;
    double amount;
    String transactionType;
    String userID;

    // Dates
    Date transactionDate;
    int day;
    int month;
    String monthName;
    int year;

    // ID which will be added once recorded is created
    // transaction_id;
    // user_id;
    // category_id;

    // Constructor
    public Transaction(String details, double amount, String transactionType, String userID, Date transactionDate, int day, int month, String monthName, int year) {
        this.details = details;
        this.amount = amount;
        this.transactionType = transactionType;
        this.userID = userID;
        this.transactionDate = transactionDate;
        this.day = day;
        this.month = month;
        this.monthName = monthName;
        this.year = year;
    }

    public static void insertTransaction(Connection conn, String details, double amount, String transactionType, String userID, Date transactionDate, int day, int month, String monthName, int year) {
        int dayBrokenDown = DateFunction.breakDownDate(transactionDate)[0];
        int monthBrokenDown = DateFunction.breakDownDate(transactionDate)[1];
        int yearBrokenDown = DateFunction.breakDownDate(transactionDate)[2];

        String []nameOfMonths = {"Jan", "Feb", "March", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};

        try {
            String query = String.format("INSERT INTO transaction(details, amount, transaction_date, user_id, transaction_type, day, month, month_name, year) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", details, amount, transactionDate, userID, transactionType, dayBrokenDown, monthBrokenDown, nameOfMonths[monthBrokenDown-1], yearBrokenDown);
            Statement statement = conn.createStatement();

            int rowsInserted = statement.executeUpdate(query);
            // Provide feedback based on the result
            if (rowsInserted > 0) {
                System.out.println("Transaction inserted successfully.");
            } else {
                System.out.println("Transaction insertion failed.");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void getSumMonth(Connection conn, int month) {
    try {
        // Prepare the SQL query
        String query = String.format(
                "SELECT SUM(amount) AS total_amount FROM transaction WHERE EXTRACT(MONTH FROM transaction_date) = %d;",
                month
        );
        Statement statement = conn.createStatement();

        // Execute the query
        ResultSet resultSet = statement.executeQuery(query);

        // Process the result
        if (resultSet.next()) {
            Double totalAmount = resultSet.getDouble("total_amount");
            if (resultSet.wasNull()) {
                totalAmount = 0.0; // Handle case where there are no transactions
            }
            System.out.printf("Total amount for month %d: R%.2f%n", month, totalAmount);
        } else {
            System.out.printf("No transactions found for month %d.%n", month);
        }

        // Close the resources
        resultSet.close();
        statement.close();
    } catch (Exception e) {

        e.printStackTrace();  // This will give you more details about the error
        throw new RuntimeException("Error fetching transaction sum", e);
    }
}


}
