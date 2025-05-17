package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbcDB";
    private static final String USERNAME = "veronika";
    private static final String PASSWORD = "veronika";
    private static Connection connection;
    private static final Logger logger = Logger.getLogger(Util.class.getName());

    private Util() {
    }

    public static Connection open() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "ошибка подключения к базе данных", e);
            }
        }
    }

}
