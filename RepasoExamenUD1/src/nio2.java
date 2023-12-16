/* Programa que lea de fichero volcando el contenido a un buffer
y mostrándolo por pantalla (similar al comando cat)
 */

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class nio2 {
    public static void main(String[] args) {
        int i=1;
        try(RandomAccessFile raf = new RandomAccessFile("texto.txt","rw");
            FileChannel fc = raf.getChannel();){

            ByteBuffer bb = ByteBuffer.allocate(10);
            //leo del canal y escribo en el buffer
            while(fc.read(bb) > 0){
                System.out.println("Bloque " + i);
                // muestro el contenido en pantalla (leo del buffer)
                bb.flip();  // para cambiar de escritura a lectura (en el buffer)
                while (bb.hasRemaining())
                    System.out.print((char) bb.get());
                i++;
                bb.clear(); // para cambiar de lectura a escritura
            }
            fc.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
