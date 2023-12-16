// Copiar el contenido de origen.txt a destino.txt (similar al comando cp de copia)

import java.io.IOException;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class nio3 {
    public static void main(String[] args) {

        Path path = Paths.get("texto2.txt");

        try(FileChannel fc = FileChannel.open(path, StandardOpenOption.READ); //fileChannel de lectura
            FileChannel fce = FileChannel.open(Paths.get("destino.txt"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);){  //fc de escritura

            ByteBuffer bb = ByteBuffer.allocate(50);

            // leer del canal de lectura para escribir en el buffer, y desde el buffer escribir al canal de escritura
            while (fce.read(bb) > 0)   // lee del canal, escribe en el buffer
            {
                //System.out.println("a");
                bb.flip();  // he escrito, ahora voy a leer del buffer
                // Para convertir de minúsculas a mayúsculas habría que trabajar posición a posición dentro del buffer
                fce.write(bb);
                bb.clear(); // he leído, ahora voy a volver a escribir
            }

        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}
