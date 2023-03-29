package D6_DB;

import java.sql.*;

public class EX01_CreateBook {

    public static void main(String[] args) {
        try {
//        add driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

//        get connection
            String url = "jdbc:sqlserver://localhost:1500;databaseName=demo_java";
            Connection con = DriverManager.getConnection(url, "sa", "boiken123");

//          create statement object
            String sql = "insert books(title, price) values ('How to drink water by mouth',200)";
            Statement stm = con.createStatement();

//          query
            int result = stm.executeUpdate(sql);

//          process result
            if (result > 0) {
                System.out.println("insert succesfully");
            } else {
                System.err.println("insert failed");
            }

            String sql2 = "insert books(title, price) values (?, ?)";
            PreparedStatement stm2 = con.prepareStatement(sql2);

            stm2.setString(1, "books");
            stm2.setInt(2, 131);

            int result2 = stm2.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
