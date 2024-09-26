import java.sql.Connection;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        System.out.println("Anvil Financing Tracking");

        DB db = new DB();
        Connection conn = db.connectDB("Anvil", "root", "root");

//        Transaction.insertTransaction(conn, "Groceries", 209.97, "debit", "Ben78", DateFunction.customDate(3, 9, 2024), 12, 10, "September", 2024);
        Transaction.getSumMonth(conn, 9);
    }
}