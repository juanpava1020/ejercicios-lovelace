package Controller;

import Entiti.Libro;
import org.riwi.bookstore_JDBC.entity.Author;
import org.riwi.bookstore_JDBC.entity.Book;
import org.riwi.bookstore_JDBC.model.BookModel;


import java.util.Scanner;

public class BookController {
    ModelLibro objLibro;
    Scanner objScanner;

    public BookController() {
        this.objScanner = new Scanner(System.in);
        this.objLibro = new ModelLibro();
    }

    public void findAll() {
        System.out.println("******* LIBRO *******");
        for (Libro book : objLibro.findAll()) {
            System.out.println("Id: " + book.getId());
            System.out.println("titulo: " + book.getTitulo());
            System.out.println("Autor: " + book.getAutorId());
            System.out.println("precio: " + book.getPrecio());
            System.out.println("año: " + book.getañoPublicacion());
            System.out.println("--!--!--!--!--!--!--!--!--!--!--!--!");
        }
    }

    public void findById() {
        System.out.print("\"Ingresa el identificador del libro.\": ");
        String id = objScanner.next();

        Libro libro = objLibro.findById(id);

        System.out.println("******* LIBRO ******");
        System.out.println("Id: " + libro.getId());
        System.out.println("titulo: " + libro.getTitulo());
        System.out.println("Autor: " + libro.getAutorId());
        System.out.println("precio: " + libro.getPrecio());
        System.out.println("año: " + libro.getAñoPublicacion());
    }

    public boolean guardar() {
        String id = String.valueOf(System.currentTimeMillis());
        System.out.print("Escribe el título del libro:");
        String titulo = objScanner.next();
        System.out.print("Escribe el año de publicación: ");
        String año = objScanner.next();
        System.out.print("Escribe el identificador del autor del libro: ");
        String autorId = objScanner.next();
        System.out.print("Ingresa el precio del libro.: ");
        double precio = objScanner.nextDouble();

        return objLibro.guardar(new Libro(id, titulo, autorId, precio, año));
    }

    public boolean update() {
        System.out.print("Escribe el identificador del libro:");
        String id = objScanner.next();
        System.out.print("Escribe el título del libro: ");
        String titulo = objScanner.next();
        System.out.print("Escribe el año de publicación:");
        String año = objScanner.next();
        System.out.print("Escribe el identificador del autor del libro: ");
        String autorId = objScanner.next();
        System.out.print("Escribe el precio del libro:");
        double precio = objScanner.nextDouble();

        return objLibro.update(new Libro(id, titulo, autorId, precio, año));
    }

    public boolean delete() {
        System.out.print("Escribe el ID del libro: ");
        String id = objScanner.next();

        return objBook.delete(id);
    }

    public void findByName() {
        AutorController controller = new AutorController();
        System.out.print("Type the author name: ");
        String nombre = objScanner.next();

        Autor autor = controller.findByName(name);

        Libro libro = objLibro.findByNombre(autor.getId());

        System.out.println("****** LIBRO ******");
        System.out.println("Id: " + libro.getId());
        System.out.println("Title: " + libro.getTitulo()ulo());
        System.out.println("Author: " + libro.getAutorId());
        System.out.println("Price: " + libro.getPrecio());
        System.out.println("Year: " + book.getYearOfPublished());
    }

    public void findByTitle() {
        System.out.print("Type the book title: ");
        String tile = objScanner.next();

        Book book = objBook.findByTitle(tile);

        System.out.println("============ BOOK ============");
        System.out.println("Id: " + book.getId());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthorId());
        System.out.println("Price: " + book.getPrice());
        System.out.println("Year: " + book.getYearOfPublished());
    }

    public void getBooksFromAuthor() {
        AuthorController controller = new AuthorController();
        Scanner scanner = new Scanner(System.in);

        controller.getAllAuthors();
        System.out.print("Type the author id: ");
        String id = scanner.next();

        System.out.println("============ BOOKS BY AUTHOR ============");
        for (Book book : objBook.getBooksFromAuthor(id)){
            System.out.println("Id: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthorId());
            System.out.println("Price: " + book.getPrice());
            System.out.println("Year: " + book.getYearOfPublished());
            System.out.println("------ AUTHOR INFORMATION -----");
            System.out.println("Id: "+book.getAuthor().getName());
            System.out.println("Name: "+book.getAuthor().getName());
            System.out.println("Nationality"+book.getAuthor().getNationality());
            System.out.println("--!--!--!--!--!--!--!--!--!--!--!--!");
        }
    }
}
