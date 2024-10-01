import java.sql.Connection;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        System.out.println("Anvil Financing Tracking");

        DB db = new DB();
        Connection conn = db.connectDB("Anvil", "root", "root");

        String userID = "4fc66ff5-48d6-43fd-92bc-b6ce02d8d6e3";

        Transaction.insertTransaction(conn, "Deodorant", 24.99, "debit", userID, DateFunction.customDate(1, 10, 2024));
//        Transaction.getSumMonth(conn, 9);

//        Refund.insertRefundRecord(conn, "Milk", 39.99, 0, false, "Boss", "4fc66ff5-48d6-43fd-92bc-b6ce02d8d6e3");
//        Refund.convertTransactionToRefundable(conn, "25ae8a85-659a-4d40-9fe8-93aec81c6edf", "Boss",userID);
//            Refund.getRefundTransactions(conn, userID);
//        Transaction.getTransactionsByType(conn, "credit", userID);
//        Transaction.getTransactionsByCategory(conn, "7c8971dd-20e7-42ef-a875-e93975638a67", "4fc66ff5-48d6-43fd-92bc-b6ce02d8d6e3");
//        Transaction.getCategorySum(conn, "7c8971dd-20e7-42ef-a875-e93975638a67", "4fc66ff5-48d6-43fd-92bc-b6ce02d8d6e3");

//        Category.showAllUserCategories(conn, "4fc66ff5-48d6-43fd-92bc-b6ce02d8d6e3");

//        Category.createCategory(conn, "fees", "4fc66ff5-48d6-43fd-92bc-b6ce02d8d6e3");

//        Category.assignCategory(conn, "51e80f34-08ed-4558-a458-7d2cf8f2efb7", "9febaa84-13ea-4619-af53-891b7de8b1ec", "4fc66ff5-48d6-43fd-92bc-b6ce02d8d6e3");

//        String userID = User.createUser(conn, "Ben Graham", "grahamben7@gmail.com", "PeterGriffin420");
//        System.out.println(userID);
    }

}