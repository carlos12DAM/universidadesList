import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

//Haciendo uso de la clase properties, guarda las propiedades de
// este examen (nombre, apellidos y materia) a fichero.

public class ej2Examen{
    public static void main(String[] args) throws IOException {
        Properties pr = new Properties();

        pr.setProperty("nombre","carlos");
        pr.setProperty("edad","21");
        pr.setProperty("apellidos","primo rico");

        try {
            pr.store(new FileOutputStream("Datos.props"),("comentario"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("MUESTRO LOS DATOS");
        Properties pr2 = new Properties();


        String nombre,edad,apellidos;
        pr2.load(new FileInputStream("Datos.props"));
        nombre = pr2.getProperty("nombre");
        edad = pr2.getProperty("edad");
        apellidos = pr2.getProperty("apellidos");

        System.out.println("nombre: " + nombre + " \napellidos: " + apellidos + " \nedad: " + edad);

    }
}

















/*public class ej2Examen {
    public static void main(String[] args) {
        Properties p1 = new Properties();

        //escribo las properties en el fichero
        p1.setProperty("nombre","Carlos");
        p1.setProperty("apellidos","Primo Rico");
        p1.setProperty("materia","AD");
        p1.setProperty("edad","21");

        try{
            //creo el fichero donde se guardaran,("datos a
            p1.store(new FileOutputStream("propiedades.props"),"almacendados");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("DATOS INTRODUCIDOS");
        Properties pr2 = new Properties();

        try{
            pr2.load(new FileInputStream("propiedades.props"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String n = pr2.getProperty("nombre");
        String a = pr2.getProperty("apellidos");
        String m = pr2.getProperty("materia");
        String edad = pr2.getProperty("edad");

        System.out.println("nombre: " + n + " \napellidos: " + a + " \nmateria: " + m + " \nedad: " + edad);
    }
}*/
