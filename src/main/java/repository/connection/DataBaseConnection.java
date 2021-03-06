package repository.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
    private final String DB_PROPERTIES = "src/main/resources/database/db.properties";

    public Connection getDbConnection() throws SQLException, IOException {
        Properties property = new Properties();
        property.load(new FileInputStream(DB_PROPERTIES));
        Connection db = DriverManager.getConnection(property.getProperty("url"), property);
        return db;
    }
}