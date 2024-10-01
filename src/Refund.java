import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Refund {
    String details;
    double amount;
    double refundedAmount;
    boolean refunded;
    String payer;
    String user_id;

    public Refund(String details, double amount, double refundedAmount, boolean refunded, String payer, String user_id){
        this.details = details;
        this.amount = amount;
        this.refundedAmount = refundedAmount;
        this.refunded = refunded;
        this.payer = payer;
        this.user_id = user_id;
    }

    public static void insertRefundRecord(Connection conn, String details, double amount, double refundedAmount, boolean refunded, String payer, String user_id){
        try{
            String query = String.format("INSERT INTO refund(details, amount, refunded_amount, refunded, payer, user_id) VALUES('%s', '%s', '%s', '%s', '%s', '%s')",details, amount, refundedAmount, refunded, payer, user_id);
            Statement statement = conn.createStatement();

            int rowsInserted = statement.executeUpdate(query);

            if (rowsInserted > 0) {
                System.out.println("Transaction inserted successfully.");
            } else {
                System.out.println("Transaction insertion failed.");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void convertTransactionToRefundable(Connection conn, String transactionID, String payer, String userID){
        try{
            String getTransactionDetails = String.format("SELECT amount, details FROM transaction WHERE transaction_id='%s' AND user_id='%s'; ", transactionID, userID);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(getTransactionDetails);

            double amount = 0.0;
            String details = "";

            while(resultSet.next()){
                amount = resultSet.getDouble("amount");
                details = resultSet.getString("details");
            }

            System.out.println(amount);
            System.out.println(details);

            try{
                String SQL = String.format("INSERT INTO refund(details, amount, refunded_amount, refunded, payer, user_id) VALUES('%s', '%s', '%s', '%s', '%s', '%s') RETURNING refund_id;",details, amount * -1, 0, false, payer, userID);
                statement = conn.createStatement();
                resultSet = statement.executeQuery(SQL);

                String refund_id = "";

                while(resultSet.next()){
                    refund_id = resultSet.getString("refund_id");
                }

                System.out.println(refund_id);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void getRefundTransactions(Connection conn, String userID){
        try{
            String SQL = String.format("SELECT * FROM refund WHERE user_id='%s'", userID);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()){
                System.out.println(resultSet.getString("details") + " " + resultSet.getFloat("amount"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
