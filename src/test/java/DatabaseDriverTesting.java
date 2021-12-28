import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class DatabaseDriverTesting {
    public static void main(String[] args) throws Exception {
        Connection conn = getConnection();
        conn.close();
    }

    static Connection getConnection() throws SQLException {
        String username = "DIGITARY_RO";// "digitary_ro";
        String password = "Bun0sc1onn$";// "C0reApp2019";
        //String thinConn = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=sidb7.ul.campus)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=SITE)))";

        // jdbc:oracle:thin:@[HOST][:PORT]:SID
        // String thinConn = "jdbc:oracle:thin:@sidb7.ul.campus:1521:SITE"; //"jdbc:oracle:thin:@//sidb7.ul.campus:1521/SITE";
        String thinConn = "jdbc:oracle:thin:@sidb7.ul.campus:1521:SIDI";
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(thinConn);
        ods.setUser(username);
        ods.setPassword(password);
        Connection conn = ods.getConnection();
        DatabaseMetaData dbmd = conn.getMetaData();
        System.out.println(dbmd.getDatabaseProductVersion());
        System.out.println("JDBC Driver version: " + dbmd.getDriverVersion());
        System.out.println("JDBC URL: " + dbmd.getURL());
        conn.setAutoCommit(false);
        return conn;
    }
}