import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//Programa que lee de un fichero volcando el contenido a un buffer
//y lo muestra por pantalla
public class nio2Rep {
    public static void main(String[] args) {

        //primero leo del fichero
        try(RandomAccessFile raf = new RandomAccessFile("texto.txt","r");
            FileChannel fc = raf.getChannel();){

            ByteBuffer bb = ByteBuffer.allocate(400);

            //leo del canal y escribo en el buffer
            while(fc.read(bb) > 0){  //le paso a donde lo quiero escribir (en el bb)

                //cambio el buffer de escritura a lectura (con flip)
                bb.flip();

                //muestro el contenido del buffer
                while(bb.hasRemaining()){
                    System.out.print((char)bb.get());
                }
                //cambio de lectura a escritura
                bb.flip();

            }
            System.out.println("EJERCICIO EXTRA");
            //ver donde estamos
            System.out.println("estoy en la posicion: " + bb.position() + " Contenido en esta posicion " + (char)bb.get());

            //PRACTICA EXTRA -> POSICIONATE EN LA POSICION 12, PON UNA MARCA
            //LEE HASTA EL FINAL Y VUELVE A LA POSICION DE LA MARCA

            bb.position(12);
            //pongo la marca
            bb.mark();
            System.out.println("posicion " + bb.position() + " caracter -> " + (char)bb.get());

            //leo hasta el final del fichero
            while(bb.hasRemaining()){
                System.out.print((char)bb.get());
            }
            //vuelvo a la posicion de la marca (con reset)
            bb.reset();
            System.out.print("posicion despues de volver a la marca " + bb.position () + " caracter " + (char)bb.get());

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
