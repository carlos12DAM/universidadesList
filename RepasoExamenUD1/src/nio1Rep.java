//Escribir caracteres de un string a un charBuffer

import java.nio.CharBuffer;

public class nio1Rep {
    public static void main(String[] args) {
        String texto = "Hola esto es un string de texto";
        CharBuffer cb = CharBuffer.wrap(texto);

        while(cb.hasRemaining()){
            System.out.print(cb.get()); //.get lee los datos de un buffer
        }
        //situate en la 5 y lee los ultimos caracteres
        System.out.println("a partir de la 5");
        cb.position(5);
        while (cb.hasRemaining()){
            System.out.print(cb.get());
        }
    }
}
