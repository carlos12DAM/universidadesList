/* Crear un buffer para guardar 10 enteros, guardar en él 10 números aleatorios entre 1 y 10.
Escribir los 10 valores del buffer a un fichero.
Finalmente, abrir el fichero para lectura y mostrar su contenido */

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class nio4 {
    public static void main(String[] args) {

        ByteBuffer bb = ByteBuffer.allocate(40);
        int nums[] = new int[10];
        for (int i=0 ; i < 10 ; i++)
            nums[i] = 1 + (int) (10*Math.random());
        // Comprobamos el contenido del array
        System.out.println(Arrays.toString(nums));
        // a partir del bytebuffer trabajo de 4 en 4 bytes (tamaño del int) con asIntBuffer y después escribo con put(int [])
        IntBuffer ib = bb.asIntBuffer();
        ib.put(nums);
        // comprobamos el contenido del buffer
        System.out.println(ib.toString());
        // después de creado y escrito el buffer, leo de él para escribir a fichero
        ib.flip();
        try (FileChannel fc = FileChannel.open(Paths.get("aleatorios.dat"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);)
        {
            // lee del bytebuffer con los 10 enteros y los escribe en el canal
            fc.write(bb);
        }
        catch (IOException ex)
        {
            System.err.println(ex.getMessage());
        }

    }
}