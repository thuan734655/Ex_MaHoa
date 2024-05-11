package ConnectDB;

import java.sql.*;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Logger;

public class Connect {
    private static String username = "root";
    private static String password = "";

    public Connect() {
    }

    public java.sql.Connection getConnection() {
        java.sql.Connection connection = null;
        try {
            // dang ky driver
            DriverManager.registerDriver(new Driver() {
                @Override
                public Connection connect(String url, Properties info) throws SQLException {
                    return null;
                }

                @Override
                public boolean acceptsURL(String url) throws SQLException {
                    return false;
                }

                @Override
                public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
                    return new DriverPropertyInfo[0];
                }

                @Override
                public int getMajorVersion() {
                    return 0;
                }

                @Override
                public int getMinorVersion() {
                    return 0;
                }

                @Override
                public boolean jdbcCompliant() {
                    return false;
                }

                @Override
                public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                    return null;
                }
            });
            String Url = "jdbc:mySQL://localhost:3306/ex_mahoa?";
            connection = DriverManager.getConnection(Url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}