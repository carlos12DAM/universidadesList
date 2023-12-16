/*3. Hacer un programa que, utilizando canales y búferes NIO, haga una copia de un fichero de texto en otro fichero donde las minúsculas sean convertidas a mayúsculas. Resuélvelo haciendo la transformación de cada caracter avanzando posición a posición en el buffer, leyendo y escribiendo con get() y put(), y ayudándote de mark() y reset() para retornar a la posición anterior.*/
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ej3markreset {
    public static void main(String[] args) {
        String inputFile = "textoej3.txt";
        String outputFile = "textoej3mayuscmarkreset.txt";

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             FileChannel inputChannel = fis.getChannel();
             FileChannel outputChannel = fos.getChannel()) {

            ByteBuffer bb = ByteBuffer.allocate(1024);

            while (inputChannel.read(bb) > 0) {
                bb.flip(); // Preparar el buffer para la lectura

                // Crear un nuevo ByteBuffer para almacenar los bytes transformados
                ByteBuffer bb2 = ByteBuffer.allocate(bb.limit());

                // Transformar minúsculas en mayúsculas
                while (bb.hasRemaining()) {
                    bb.mark(); // Marcar la posición actual

                    char c = (char) bb.get();
                    if (Character.isLowerCase(c)) {
                        c = Character.toUpperCase(c);
                        bb2.put((byte) c);
                    } else {
                        bb.reset(); // Retornar a la posición anterior
                        bb2.put(bb.get());
                    }
                }
                // Preparar el buffer para la escitura
                bb2.flip();
                outputChannel.write(bb2);
                bb.clear(); // Limpiamos el buffer para futuras lecturas
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
