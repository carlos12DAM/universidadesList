//5. Crea 2 IntBuffers con capacidad para 10 enteros cada uno de ellos.
// Guarda, de entre los 20 primeros números naturales, los pares en uno y los impares en otro.
// Escribe el contenido de ambos búferes a un fichero "numeros.dat".
// Lee el contenido del fichero con un ScatteringByteChannel que reparta el contenido en 4 búferes.
// Reune el contenido del primer y tercer buffer en un nuevo fichero con GatheringByteChannel.

import java.nio.channels.ScatteringByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class ej5
{
    public static <sbc> void main(String[] args)
    {
        ByteBuffer pares = ByteBuffer.allocate(40);
        ByteBuffer inpares = ByteBuffer.allocate(40);

        //escribir numeros pares e impares del 1 al 20 en sus respectivos buffers
        for (int i = 1; i <= 20; i++)
        {
            if(i%2 == 0)
                pares.putInt(i);
            else
                inpares.putInt(i);
        }

        try(FileChannel fc = FileChannel.open(Paths.get("numeros.dat"), StandardOpenOption.CREATE,StandardOpenOption.WRITE);
            ScatteringByteChannel sbc = FileChannel.open(Paths.get("numeros.dat")))
        {
            pares.flip();
            inpares.flip();

            fc.write(pares);
            fc.write(inpares);

            System.out.println("COMPLETADO");

            pares.clear();
            inpares.clear();

            sbc.read(new ByteBuffer[] {pares,inpares});

            pares.flip();
            inpares.flip();

            System.out.println("IMPRIMIR BYTEBUFFERS 1");
            while (inpares.hasRemaining())
            {
                System.out.println(inpares.getInt());
            }

            System.out.println("IMPRIMIR BYTEBUFFERS 2");
            while (pares.hasRemaining())
            {
                System.out.println(pares.getInt());
            }
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
