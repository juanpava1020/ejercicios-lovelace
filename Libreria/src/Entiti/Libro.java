package Entiti;

//****CREO LA CLASE "LIBRO" Y HEREDO EL ID DEL PADRE "AUTOR"****
public class Libro extends Autor {
private int id;
private String titulo;
private double añoPublicacion;
private double precio;
private String autor;

//****CREO EL CONSTRUCTOR****

//****CONSTRUCTO VACIO****
    public Libro() {
    }
//****CONSTRUCTOR LLENO ****


    public Libro(int id, String nombre, String nacionalidad, int id1, String titulo, double añoPublicacion, double precio, String autor) {
        super(id, nombre, nacionalidad);
        this.id = id1;
        this.titulo = titulo;
        this.añoPublicacion = añoPublicacion;
        this.precio = precio;

    }

    //****GENERO EL GETTER AND SETTER

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(double añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }




    //****GENERO EL toString()


    @Override
    public String toString() {
        return super.toString() + "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", añoPublicacion=" + añoPublicacion +
                ", precio=" + precio +

                '}';
    }
}
