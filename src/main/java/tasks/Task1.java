package tasks;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task1 {
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
                FROM employees
                ORDER BY experience DESC
                LIMIT 1 OFFSET 1;""";
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql);

        rs.next();
        return rs.getString("surname");
    }
}
