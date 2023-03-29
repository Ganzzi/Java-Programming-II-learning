package D6_DB;

import java.sql.*;

public class EX02_DisplayBook {

    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1500;databaseName=demo_java";
            Connection con = DriverManager.getConnection(url, "sa", "boiken123");

            String sql = "select * from books";
            Statement stm = con.createStatement();

            ResultSet result = stm.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt(1), price = result.getInt(3);
                String title = result.getString(2);
                System.out.printf("%d-%s-%d\n", id, title, price);
//          1-int      2-String      3-int
//          id         title         price
            }

//          updatable
            Statement stm2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); // config starement

            result.close();
            stm.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
