import java.sql.Connection;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        System.out.println("Anvil Financing Tracking");

        DB db = new DB();
        Connection conn = db.connectDB("Anvil", "root", "root");

        Transaction.insertTransaction(conn, "Test", 24000.00, "credit", "4fc66ff5-48d6-43fd-92bc-b6ce02d8d6e3", DateFunction.customDate(30, 9, 2024));
        Transaction.getSumMonth(conn, 9);

//        Category.createCategory(conn, "fees", "4fc66ff5-48d6-43fd-92bc-b6ce02d8d6e3");

//        Category.assignCategory(conn, "51e80f34-08ed-4558-a458-7d2cf8f2efb7", "9febaa84-13ea-4619-af53-891b7de8b1ec", "4fc66ff5-48d6-43fd-92bc-b6ce02d8d6e3");

//        String userID = User.createUser(conn, "Ben Graham", "grahamben7@gmail.com", "PeterGriffin420");
//        System.out.println(userID);
    }
}