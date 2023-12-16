//copiar el contenido de origen.txt a destino.txt

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class nio3Rep {
    public static void main(String[] args) {
        //primero obtengo el contenido de origen.txt
        try(RandomAccessFile rafLec = new RandomAccessFile("origen.txt","r");
            RandomAccessFile rafEsc = new RandomAccessFile("destino.txt","rw");
            FileChannel fc = rafLec.getChannel();
            FileChannel fcEsc = rafEsc.getChannel()){

            ByteBuffer bb = ByteBuffer.allocate(50);
            //leemos del canal y lo pasamos al ByteBuffer
            while(fc.read(bb) > 0){
               //ya he escrito en el buffer
               //cambio el buffer de escritura a lectura
               bb.flip();
               //Ahora del buffer lo escribo en el otro fichero
                fcEsc.write(bb);
                //vuelvo a cambiar de lectura a escritura
                bb.flip();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
