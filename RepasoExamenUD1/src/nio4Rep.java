import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

//escribe 10 enteros entre el 1 y el 10 y escribelo en un fichero llamado "enteroRep.bin"
public class nio4Rep {
    public static void main(String[] args) {
        //creo el byteBuffer
        ByteBuffer bb = ByteBuffer.allocate(40);
        //generamos los 10 aleatorios
        int numeros[] = new int[10];
        for(int i=0 ; i < numeros.length ; i++){
            numeros[i] = (int)(Math.random()*10) + 1;
            System.out.println(numeros[i]);
        }
        //escribo los numeros en el ByteBuffer, convirtiendolo en intBuffer
        IntBuffer ib = bb.asIntBuffer();
        //escribo los numeros en el IntBuffer
        ib.put(numeros); //put() escribe los numeros, get() lee el contenido

        try(RandomAccessFile raf = new RandomAccessFile("enterosRep.bin","rw");
            FileChannel fc = raf.getChannel();
            RandomAccessFile rafL = new RandomAccessFile("enterosRep.bin","r");
            FileChannel fcL = rafL.getChannel();){

            //cambio el buffer de escritura a lectura
            ib.flip();
            //escribo el canal
            fc.write(bb);

            //EJERCICIO APARTE : LEE EL CONTENIDO DEL RAF
            ib.flip();
            //leo del canal
            ByteBuffer bbL = ByteBuffer.allocate(50);
            System.out.println("---CONTENIDO LEIDO----");
            while(fcL.read(bbL) > 0){
                bbL.flip();
                IntBuffer ib2 = bbL.asIntBuffer();
                while(ib2.hasRemaining()) {
                    System.out.println(ib2.get());
                }
                bbL.flip();
            }


        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
