/* muestra todo el contenido de un fichero de texto utlizando un canal IMP ESTE */

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class nioChannelDemo {
    public static void main(String args[]) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("texto.txt", "r");
        FileChannel fc = raf.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(512);
        while (fc.read(bb) > 0) {
            // paso de lectura a escritura
            bb.flip();
            while (bb.hasRemaining())
                System.out.print((char) bb.get());
            //byteBuffer.rewind(); // o byteBuffer.clear();
        }
        raf.close();
    }
}