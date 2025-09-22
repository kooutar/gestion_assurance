package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    public static DataBase instace;
    private Connection connection;
    private DataBase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("✅ Driver JDBC MySQL chargé avec succès !");
        connection= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/gestionassurance",
                "root",
                "root"
        );
        System.out.println("✅ Connexion réussie !");
    }

    public static DataBase getInstance() throws SQLException, ClassNotFoundException {
        if (instace == null) {
            instace = new DataBase();
        }
        return instace;
    }
    public Connection getConnection() {
        return connection;
    }
}
