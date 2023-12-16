import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//NO ENTRO EN EL EXAMEN
 class lecturaPropertiesExamen {
    public static void main(String[] args) {
        Properties pr = new Properties();

        try {
            pr.load(new FileInputStream("propertiesExamen.props"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String nombre = pr.getProperty("nombre");
        String apellidos =  pr.getProperty("Apellidos");
        String materia = pr.getProperty("Materia");

        System.out.println("nombre completo " + nombre + " " + apellidos + " materia " + materia);
    }
}
