package Controller;

import java.util.Scanner;


public class AutorController {
    AutorModel objAutor;
    Scanner objScanner;

    public AutorController() {
        this.objAutor = new AutorModel();
        this.objScanner = new Scanner(System.in);
    }

    public boolean updateAutor() {
        System.out.print("ingresa el id: ");
        String id = objScanner.next();
        System.out.print("ingresa el nombre: ");
        String nombre = objScanner.next();
        System.out.print("ingresa la nacionalidad: ");
        String nacionalidad = objScanner.next();

        return objAutor.updateAutor(new Autor(id, nombre, nacionalidad));
    }

    public boolean insertAutor() {
        String id = String.valueOf(System.currentTimeMillis());
        System.out.print("ingrese el nombre: ");
        String nombre = objScanner.next();
        System.out.print("ingrese la nacionalidad: ");
        String nacionalidad = objScanner.next();

        return objAutor.insertAutor(new Autor(id, nombre, nacionalidad));
    }

    public boolean deleteAutor() {
        System.out.print("ingrese el id: ");
        String id = objScanner.next();

        return objAutor.deleteAutor(id);
    }

    public void getAllAutors() {

        System.out.println("****** autores *******");
        for (Autor autor : objAutor.getAllAutors()){
            System.out.println("Id: " + autor.getId());
            System.out.println("nombre: " + autor.getName());
            System.out.println("Nationality: " + author.getNationality());

        }
    }

    public void getAuthorById() {
        System.out.print("Enter the author id: ");
        String id = objScanner.next();

        Author author = objAuthor.getAuthorById(id);

        System.out.println("============ AUTORS ============");
        System.out.println("Id: " + author.getId());
        System.out.println("Name: " + author.getName());
        System.out.println("Nationality: " + author.getNationality());
        System.out.println("--!--!--!--!--!--!--!--!--!--!--!--!");
    }

    public Autor findByName(String nombre) {
        Autor autor = objAutor.getAuthorByName(nombre);

//        System.out.println("============ AUTHORS ============");
//        System.out.println("Id: " + author.getId());
//        System.out.println("Name: " + author.getName());
//        System.out.println("Nationality: " + author.getNationality());
//        System.out.println("--!--!--!--!--!--!--!--!--!--!--!--!");

        return author;
    }

}