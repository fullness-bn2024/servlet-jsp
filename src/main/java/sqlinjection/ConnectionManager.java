package sqlinjection;
import java.sql.Connection;
import java.sql.DriverManager;
/*
 * DB接続クラス
 */
public class ConnectionManager {
  static final String JDBC_DRIVER = "org.postgresql.Driver";
  static final String DB_URL = "jdbc:postgresql://localhost:5432/security";
  static final String USER = "security";
  static final String PASS = "security";
  public static Connection getConnection() {
    try {
      Class.forName(JDBC_DRIVER);
      return DriverManager.getConnection(DB_URL, USER, PASS);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}