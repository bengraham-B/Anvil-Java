import java.sql.*;

public class DB {
    public Connection connectDB(String dbName, String user, String password){
        Connection conn = null;

        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5429/"+dbName,user,password);

            //^ Checking if connection is successful
            if(conn != null){
                System.out.println("Connection Established :)");
            } else {
                System.out.println("Connection Failed :(");
            }
        } catch(Exception e){
            System.out.println(e);
        }

        // Returning Connection Object
        return conn;

    }

    public void backDB(Connection conn){

    }
}
