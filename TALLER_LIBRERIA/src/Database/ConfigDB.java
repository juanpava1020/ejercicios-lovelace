package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    static Connection objConnection = null;

    public static Connection openConnection() {
        try {

            //control alt shift j es lo mismo que el control d

            //class forName permite obtener o implementar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creamos variables con nuestra credenciales de la base de datos
            String url = "mysql://uhw3dnavz3bq3sn6:3oVUTJfq2C7gZvIkZj97@buu5z38r51tt6gvpf7uw-mysql.services.clever-cloud.com:3306/buu5z38r51tt6gvpf7uw";
            String user = "uhw3dnavz3bq3sn6";
            String password = "3oVUTJfq2C7gZvIkZj97";
            //Establecemos la conexión
            objConnection = DriverManager.getConnection(url, user, password);
            System.out.println("Successful connection!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error >> Driver not Installed");
        } catch (SQLException e) {
            System.out.println("Error >> A connection to the database could not be established");
        }
        return objConnection;
    }

    public static void closeConnection() {
        try {
            if (objConnection != null) objConnection.close();
            System.out.println("Connection Finished");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
