package Model;


import Database.CRUD_Libro;
import Database.ConfigDB;
import Entiti.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class libroModel implements CRUD_Libro {
    Connection objConnection;

    @Override
    public Object Insertar(Object obj) {
        return null;
    }

    @Override
    public List<Object> Consultar() {
        return null;
    }

    @Override
    public Boolean actualizar(Object obj) {
        return null;
    }

    @Override
    public Boolean eliminar(Object obj) {
        return null;
    }

    public List<Libro> findAll() {
        objConnection = ConfigDB.openConnection();
        List<Libro> Libros = new ArrayList<Libro>();

        try {
            String sql = "SELECT * FROM Libro";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String titulo = resultSet.getString("title");
                    String año = resultSet.getString("añoPublicacion");
                    String autorId = resultSet.getString("autorId");
                    double precio = resultSet.getDouble("precio");

                    Libro libro = new Libro(id, titulo, autorId, precio, año);
                    Libros.add(Libro);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigDB.closeConnection();
        return Libros;
    }


    public Libro findById(String id) {
        objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM Libro WHERE Libro.id = ? ;";

            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();
                String id = resultSet.getString("id");
                String titulo = resultSet.getString("titulo");
                String año = resultSet.getString("año de publicacion");
                String autorId = resultSet.getString("autorId");
                double precio = resultSet.getDouble("precio");

                Libro objLibro = new Libro(id, titulo, autorId, precio, año);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return Libro;
    }


    public Libro findByTitle(String titulo) {
        objConnection = ConfigDB.openConnection();
        Libro libro;
        try {
            String sql = "SELECT * FROM book WHERE book.title like '%" + titulo + "%';";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();
                String libroId = resultSet.getString("id");
                String tituloNew = resultSet.getString("titulo");
                String año = resultSet.getString("año de publicacion");
                String autorId = resultSet.getString("autorId");
                double precio = resultSet.getDouble("precio");

                libro = new Libro(libroId, tituloNew, autorId, precio, año);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return Libro;
    }

    @Override
    public Libro findByName(String id) {
        objConnection = ConfigDB.openConnection();
        Libro libro;
        try {
            String sql = "SELECT * FROM libro WHERE libro.autorId = "+id+";";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();
                String libroId = resultSet.getString("id");
                String tituloNew = resultSet.getString("titulo");
                String año = resultSet.getString("año de publicacion");
                String autorId = resultSet.getString("autorId");
                double precio = resultSet.getDouble("precio");

                libro= new libro(libroId, tituloNew, autorId, precio, año);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return libro;
    }

    @Override
    public boolean save(Libro libro) {
        objConnection = ConfigDB.openConnection();
        try {
            String sql = "INSERT INTO libro (id,titulo, autorId, precio,año de publicacion) VALUES (?,?,?,?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, Libro.getId());
            statement.setString(2, Libro.getTitulo());
            statement.setString(3, Libro.getAutorId());
            statement.setDouble(4, Libro.getPrecio());
            statement.setString(5, Libro.getAñoPublicacion());

            statement.execute();

            System.out.println("\"Inserción del libro completada exitosamente\".");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return true;
    }

    @Override
    public boolean actualizar(Object obj) {
        Libro objLibro
        objConnection = ConfigDB.openConnection();
        try {
            String sql = "UPDATE libro SET titulo = ?, autorId = ?, precio = ?, añoDePublicacion = ?  WHERE (id = ?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, libro.getTitulo());
            statement.setString(2, libro.getAutorId());
            statement.setDouble(3, libro.getPrecio());
            statement.setString(4, libro.getAñoDePublicacion());
            statement.setString(5, libro.getId());


            statement.executeUpdate();

            System.out.println("\"El libro se actualizó correctamente\".");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigDB.closeConnection();
        return true;
    }

    @Override
    public boolean delete(String id) {
        objConnection = ConfigDB.openConnection();

        try {
            String sql = "DELETE FROM libro WHERE id = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, id);

            statement.execute();
            System.out.println("The row was deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public List<Libro>  getBooksFromAutor(String idAutor){
        objConnection = ConfigDB.openConnection();
        List<Libro> libros = new ArrayList<Libro>();

        try {
            String sql = "SELECT *FROM libro INNER JOIN autor ON libro.autorId = autor.id WHERE autor.id = ?;";

            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {

                statement.setString(1,idAutor);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String titulo = resultSet.getString("titulo");
                    String año = resultSet.getString("añoPublicacion");
                    String autorId = resultSet.getString("autorId");
                    double precio = resultSet.getDouble("precio");
                    String nombre = resultSet.getString("nombre");
                    String nacionalidad = resultSet.getString("nacionalidad");

                    Autor autor = new Autor(idAutor,nombre,nacionalidad);
                    Libro libro = new Libro(id, titulo, autorId, precio, año,autor);
                    libros.add(libro);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigDB.closeConnection();
        return libros;
    }
}