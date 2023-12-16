import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

//Haciendo uso de la clase properties, guarda las propiedades de este examen (nombre, apellidos y materia) a fichero.
public class ej2ExamenProperties {
    public static void main(String[] args) {
        //creo el properties
        Properties pr = new Properties();

        //escribo las properties en el fichero
        pr.setProperty("nombre","Carlos"); //nombre = clave , Carlos = valor
        pr.setProperty("Apellidos","Primo Rico");
        pr.setProperty("Materia","Acceso a Datos");

        //creo el fichero donde se guardaran
        try {
            pr.store(new FileOutputStream("propertiesExamen.props"),"datos almacenados");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
