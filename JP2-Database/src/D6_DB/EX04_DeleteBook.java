package D6_DB;

import java.sql.*;

public class EX04_DeleteBook {

    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1500;databaseName=demo_java";
            Connection con = DriverManager.getConnection(url, "sa", "boiken123");

            String sqlQuery = "delete from books where id=?";
            PreparedStatement stm = con.prepareStatement(sqlQuery);
            stm.setInt(1, 2);
            
            int rs = stm.executeUpdate();

            if (rs > 0) {
                System.out.println("Done");
            } else {
                System.err.println("Failed");
            }

            stm.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
