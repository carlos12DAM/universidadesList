import java.sql.SQLOutput;
import java.util.ArrayList;

public class Libros {
    private ArrayList<Libro> libro;


    // Constructor sin parámetros que inicializa el ArrayList.
    public Libros(){
        libro = new ArrayList<>();
    }

    //Método que agrega objetos Libro al ArrayList.
   public void agregaLibros(Libro l){
        libro.add(l);
   }
   //metodo que muestra los libros
    public void muestraLibros(){
        for(Libro l : libro)
            System.out.println(l);
    }
    @Override
    public String toString() {
        return "Libros{" +
                "libro=" + libro +
                '}';
    }
}
