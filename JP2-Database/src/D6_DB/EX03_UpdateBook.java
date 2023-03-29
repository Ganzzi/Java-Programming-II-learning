package D6_DB;

import java.sql.*;

public class EX03_UpdateBook {

    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1500;databaseName=demo_java";
            Connection con = DriverManager.getConnection(url, "sa", "boiken123");

            String sqlQuery = "update books set title=?, price=? where id=?";
            PreparedStatement stm = con.prepareStatement(sqlQuery);
            stm.setString(1, "book 3");
            stm.setInt(2, 45);
            stm.setInt(3, 1);

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
