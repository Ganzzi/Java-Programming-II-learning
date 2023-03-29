package Assignment_lab6;

import java.sql.*;
import java.util.*;

public class ProjectTest {

    List<Project> ds = new ArrayList<>();

    private Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1500;databaseName=javaDB";
        Connection cn = DriverManager.getConnection(url, "sa", "boiken123");
        return cn;
    }

    public ProjectTest() throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }

    public int insert(Project pro) throws SQLException {
        Connection cn = getConnection();

        PreparedStatement stm = cn.prepareStatement("insert tbProject (projectName, startDate, [value], completed) values (?, ?, ?, ?)");

        stm.setString(1, pro.projectName);
        stm.setString(2, pro.startDate);
        stm.setInt(3, pro.value);
        stm.setBoolean(4, pro.completed);

        int rs = stm.executeUpdate();

        if (rs > 0) {
            return 1;
        }

        return -1;
    }

    public int delete(Integer pID) throws SQLException {
        Connection cn = getConnection();

        PreparedStatement stm = cn.prepareStatement("delete from tbProject where id = ?");

        stm.setInt(1, pID);

        int rs = stm.executeUpdate();

        if (rs > 0) {
            return 1;
        }

        return -1;
    }

    public List<Project> getList() throws SQLException {
        Connection cn = getConnection();

        Statement stm = cn.createStatement();

        String sql = "select * from tbProject";
        ResultSet rs = stm.executeQuery(sql);

        ds.clear();

        while (rs.next()) {
            int id = rs.getInt(1), value = rs.getInt(4);
            String name = rs.getString(2), date = rs.getString(3);
            boolean completed = rs.getBoolean(5);

            Project _p = new Project(id, value, name, date, completed);
            ds.add(_p);
        }

        return ds;
    }

    public List<Project> getCompletedList() throws SQLException {
        Connection cn = getConnection();

        Statement stm = cn.createStatement();

        String sql = "select * from tbProject where completed=1";
        ResultSet rs = stm.executeQuery(sql);

        ds.clear();

        while (rs.next()) {
            int id = rs.getInt(1), value = rs.getInt(4);
            String name = rs.getString(2), date = rs.getString(3);
            boolean completed = rs.getBoolean(5);

            Project _p = new Project(id, value, name, date, completed);
            ds.add(_p);
        }

        return ds;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ProjectTest p = new ProjectTest();
        Scanner sc = new Scanner(System.in);

        int choice = 0;

        do {
            System.out.println("1. Create new project");
            System.out.println("2. Display project List");
            System.out.println("3. Display completed project List");
            System.out.println("4. Delete project by id.");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    Project _p = new Project();
                    _p.input();

                    int n = p.insert(_p);

                    if (n > 0) {
                        System.out.println("success");
                    } else {
                        System.err.println("failed");
                    }
                    break;
                case 2:
                    List<Project> _l = p.getList();
                    if (!_l.isEmpty()) {
                        _l.forEach(s -> System.out.println(s));
                    } else {
                        System.err.println("error");
                    }
                    break;
                case 3:
                    List<Project> _cl = p.getCompletedList();
                    if (!_cl.isEmpty()) {
                        _cl.forEach(s -> System.out.println(s));
                    } else {
                        System.err.println("error");
                    }
                    break;
                case 4:
                    System.out.println("enter id: ");
                    int _i = Integer.parseInt(sc.nextLine());

                    int n2 = p.delete(_i);

                    if (n2 > 0) {
                        System.out.println("success");
                    } else {
                        System.err.println("failed");
                    }
                    break;
                case 5:
                    System.exit(0);
                default:
                    throw new AssertionError();
            }
        } while (choice != 5);
    }
}
