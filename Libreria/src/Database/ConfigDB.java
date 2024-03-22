package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//*****clase encargada de establecer y cerrar la conexion con la base de datos*****
public class ConfigDB {
    // *****esta es el atributo que va a contener el estado de la conexion*****
public static Connection objConnection = null;

//*****metodo para conectar la base de datos*****
public static Connection openConnection(){
    try {
        //*****el driver lo importa intellij automaticamente*****
        Class.forName ("com.mysql.cj.jdbc.Driver");

        //*****creamos la variable de conexion*****
        String url ="mysql://uhw3dnavz3bq3sn6:3oVUTJfq2C7gZvIkZj97@buu5z38r51tt6gvpf7uw-mysql.services.clever-cloud.com:3306/buu5z38r51tt6gvpf7uw";
        String user ="uhw3dnavz3bq3sn6";
        String password="3oVUTJfq2C7gZvIkZj97";

        //*****establece la conexion*****
        objConnection = (Connection) DriverManager.getConnection(url,user,password);
        System.out.println("se conecto perfectamente🙉");

        //*****el PRIMER catch es el ERROR por si me falla la INSTALACION del DRIVER*****
    }catch (ClassNotFoundException error){
        System.out.println("ERROR >> DRIVER no instalado" + error.getMessage());

        //*****el SEGUNDO catch es el ERROR por si me falla la CONEXION con la BASE DE DATOS*****
    }catch (SQLException error){
        System.out.println("ERROR >> error al conectarse con la base de datos" + error.getMessage());
    }
    return objConnection;
}
    //*****metodo para cerrar la conexion*****
public static void closeConnection(){
try {
    if(objConnection != null){
        objConnection.close();
        System.out.println("se finalizo la conexion con exito");
    }

}catch (SQLException error){
    System.out.println("ERROR >> "+ error.getMessage());

}
}
}