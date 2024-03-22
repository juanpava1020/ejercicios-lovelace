package Model;

import Database.CRUD_Autores;
import Database.ConfigDB;
import Entiti.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorModel implements CRUD_Autores {

    Connection objConnection;

    @Override
    public Object Insertar(Object autor) {
        objConnection = ConfigDB.openConnection();
        Autor objAutor = (Autor) autor;
        try {
            String sql = "INSERT INTO autor (id,nombre, nacionalidad) VALUES (?,?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, objAutor.getId());
            statement.setString(2, objAutor.getNombre());
            statement.setString(3, objAutor.getNacionalidad());

            statement.execute();

            System.out.println("La inserción del autor se completó correctamente");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return true;
    }

    @Override
    public List<Object> Consultar() {
        return null;
    }

    @Override
    public Boolean actualizar(Object obj) {
        objConnection = ConfigDB.openConnection();
        Autor objAutor = (Autor) obj;
        try {
            String sql = "UPDATE author SET name = ?, nationality = ?  WHERE (id = ?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, objAutor.getNombre());
            statement.setString(2, objAutor.getNacionalidad());
            statement.setInt(3, objAutor.getId());

            statement.executeUpdate();

            System.out.println("Autor was update successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return true;
    }

    @Override
    public Boolean eliminar(Object autorIdString) {
        objConnection = ConfigDB.openConnection();
        int idAutor = (Integer) autorIdString;

        try {
            String sql = "DELETE FROM author WHERE id = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, idAutor);

            statement.execute();
            System.out.println("The row was deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }




    public List<Autor> getAllAutores() {
        objConnection =ConfigDB.openConnection();
        List<Autor> autores = new ArrayList<Autor>();

        try {
            String sql = "SELECT * FROM autor";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String nacionalidad = resultSet.getString("nacionalidad");

                    Autor autor = new Autor(id, nombre, nacionalidad);
                    autores.add(autor);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigDB.closeConnection();
        return autores;
    }

    public Autor getAutorById(String autorId) {
        objConnection = ConfigDB.openConnection();
        Autor autor;
        try {
            String sql = "SELECT * FROM autor WHERE autor.id = " + autorId + ";";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();

                String nombre = resultSet.getString("nombre");
                String nacionalidad = resultSet.getString("nacionalidad");
                int id = resultSet.getInt("id");

                autor = new Autor(id, nombre, nacionalidad);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return autor;
    }


    public Autor getAuthorByName(String nombre) {
        objConnection = ConfigDB.openConnection();
        Autor autor;
        try {
            String sql = "SELECT * FROM autor WHERE nombre = '" + nombre + "';";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();

                String nombreNew = resultSet.getString("nombre");
                String nacionalidad = resultSet.getString("nacionalidad");
                int id = resultSet.getInt("id");

                autor = new Autor(id, nombreNew, nacionalidad);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return autor;
    }
}