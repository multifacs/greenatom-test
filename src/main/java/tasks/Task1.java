package tasks;

import java.sql.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task1 {

    private static final ExecutorService executor
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
            String[] queries = {
                    "DROP TABLE IF EXISTS employees;",
                    """
                    CREATE TABLE employees (
                    	id INTEGER PRIMARY KEY AUTOINCREMENT,
                    	surname VARCHAR NOT NULL,
                    	experience INTEGER
                    );""",
                    "INSERT INTO employees(surname, experience) VALUES('Иванов', 10);",
                    "INSERT INTO employees(surname, experience) VALUES('Петров', 12);",
                    "INSERT INTO employees(surname, experience) VALUES('Сидоров', 14);"
            };

            for (String sql : queries) {
                Statement stmt = conn.createStatement();
                stmt.execute(sql);
            }
        }
    }

    public static String selectSecondMaxExp(Connection conn) throws SQLException {
        String sql = """
                SELECT surname
                FROM employees e
                WHERE 2 = (SELECT COUNT (DISTINCT experience)\s
                           FROM employees p
                           WHERE e.experience<=p.experience);""";
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);

        rs.next();
        return rs.getString("surname");
    }
}
