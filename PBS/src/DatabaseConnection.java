import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection con;

    public static Connection dbConnection() {
        if (con != null) {
            return con;
        }

        Properties properties = new Properties();
        try {

            FileInputStream fis = new FileInputStream("src/config.properties");
            properties.load(fis);

            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            con = DriverManager.getConnection(url, username, password);
        } catch (IOException e) {
            System.out.println("Hata");
        }
        catch (SQLException e) {
            System.out.println("Veritabanına bağlanılamadı..");
        }
        return con;
    }
}

