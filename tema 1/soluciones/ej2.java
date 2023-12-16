//2. Copia el contenido de un fichero en otro haciendo uso de los métodos estáticos de la clase Files de java.nio.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ej2 {
        public static void main(String[] args) throws IOException {

            Path origen = Paths.get("origen.txt");
            Path destino = Paths.get("destino2.txt");

            Files.copy(origen, destino);

        }
    }
