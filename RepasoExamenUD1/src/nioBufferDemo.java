//Ejemplo con la implementacion de los metodos vistos anteriormente IMPORTANTE ESTE

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
public class nioBufferDemo {
    public static void main(String[] args) {
        //crear buffer para 10 caracteres
        CharBuffer bb = CharBuffer.allocate(10);
        String texto = "bufferDemo";
        System.out.println("input text: " + texto);
        bb.put(texto);
        int buffPos = bb.position();
        System.out.println("Posición después de la escritura en el buffer: " + buffPos);
        bb.flip();
        System.out.println("Leyendo contenido del buffer:");
        while(bb.hasRemaining()){
            System.out.println(bb.get());
        }
        // estableciendo la posición del buffer en 5.
        bb.position(5);
        // estableciendo la marca según la posición
        bb.mark();
        // intentando volver a cambiar la posición
        bb.position(6);
        System.out.println("Restaurada la posición del buffer: " + bb.position());
        // utilizando el método reset para restaurar la posición marcada
        // reset() lanza InvalidMarkException si la marca no se puede establecer
        // o si la nueva posición es inferior que la posición marcada
        bb.reset();
        System.out.println("Restaurada la posición del buffer: " + bb.position());
    }
}
