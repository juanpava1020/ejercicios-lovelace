import Controller.LibroController;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    String opcion = "";


    public void menuAutor(){
        LibroController controller = new LibroController();
       String opcion ="";
        do {
            opcion = JOptionPane.showInputDialog("""
                    ***MENU AUTOR***
                    1. insertar autor
                    2. consultar
                    3. actualizar
                    4. eliminar
                    5. salir
                    ***ingresa una opcion***
                    """);
                    switch (opcion){
                        case "1":

                            break;
                        case "2":

                            break;
                        case "3":

                            break;
                        case "4":

                            break;
                    }
        }while (opcion.equals("5"));
        }

        public void menuLibro(){
            String opcion ="";
            do {
                opcion = JOptionPane.showInputDialog("""
                    ***MENU libro***
                    1. insertar libro
                    2. consultar
                    3. actualizar
                    4. eliminar
                    5. salir
                    ***ingresa una opcion***
                    """);
                switch (opcion){
                    case "1":

                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                    case "4":

                        break;
                }
            }while (opcion.equals("5"));
        }
        do {
            opcion = JOptionPane.showInputDialog("""
                *** MENU ***
                1. autor
                2. libro
                3. salir
                *** Elige una opcion *** 
                """);
            switch (opcion){
                case "1":
                    menuAutor();
                    break;
                case "2":
                    menuLibro();
                    break;
            }
        }while (opcion.equals("3"));

    }
}