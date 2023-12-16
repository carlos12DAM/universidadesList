package com.rca;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/* volcar el contenido de un fichero de texto en un buffer, mostrar el contenido del buffer, copiar cada caracter (transformando
cada minúscula en mayúscula) y escribir el contenido transformado a un 2º fichero */

public class ej3 {

    public static void main(String[] args) {
	// write your code here
        ByteBuffer bf = ByteBuffer.allocate(10);

        try (FileChannel fc = FileChannel.open(Paths.get("ent.txt"), StandardOpenOption.READ);
             FileChannel fc2 = FileChannel.open(Paths.get("sal.txt"),StandardOpenOption.CREATE, StandardOpenOption.WRITE);){
            do {
                bf.clear();
                //System.out.println("Entrant al do-while");

                int leidos = fc.read(bf);
                System.out.println(leidos);
                if (leidos < 0)
                    return;
                //System.out.println("llegint del canal d'entrada");
                bf.flip();
                while (bf.hasRemaining())
                {
                    bf.mark();
                    byte c= bf.get();
                    if ((c >= 97) && (c<=122))
                        c -= 32;
                    bf.reset();
                    bf.put(c);
                }
                System.out.println("----");

                /* Escribimos el contenido del buffer a salida.txt */
                bf.rewind();
                //while (bf2.hasRemaining())
                    fc2.write(bf);
                System.out.println("===============");
            } while (true);
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
