package tasks;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task1 {

    private ExecutorService executor
            = Executors.newSingleThreadExecutor();

    static class Repository {
        public static Connection connect() {
            Connection conn = null;
            try {
                String url = "jdbc:sqlite::memory:";
                conn = DriverManager.getConnection(url);

                System.out.println("Connection established");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } // finally {
//                try {
//                    if (conn != null) {
//                        conn.close();
//                    }
//                } catch (SQLException ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }

            return conn;
        }

        public static void migrate(Connection conn) throws SQLException {
            // SQL statement for creating a new table
            String sql = "DROP TABLE IF EXISTS employees;\n"
                    + "CREATE TABLE IF NOT EXISTS employees (\n"
                    + "	id number PRIMARY KEY,\n"
                    + "	surname varchar NOT NULL,\n"
                    + "	experience number\n"
                    + ");"
                    + "INSERT INTO employees(surname, experience)\n"
                    + "VALUES('Иванов', 10),\n"
                    + "VALUES('Петров', 12),\n"
                    + "VALUES('Сидоров', 14);";

            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        }
    }

    public static String selectSecondMaxExp(Connection conn) throws SQLException {
        String sql = "SELECT name FROM employees\n"
                + "ORDER BY experience;";
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.println(rs.getInt("id") +  "\t" +
                    rs.getString("surname") + "\t" +
                    rs.getInt("experience"));
        }

        return "123";
    }
}
