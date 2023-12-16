import java.nio.CharBuffer;

public class nio1 {
    public static void main(String[] args) {
        //CharBuffer cb = CharBuffer.allocate(10);
        String s = "BufferDemoDAM";
         // También podría crear el buffer con wrap
        CharBuffer cb = CharBuffer.wrap(s);

        // Escribo el String en el buffer
        //cb.put(s);

        // Cambio de modo escritura a modo lectura con flip()
        //cb.flip();
        while (cb.hasRemaining()) {
            System.out.print(cb.get());
            System.out.println(" leído en la posición " + cb.position());
        }
        
// establezco la marca en la última posición
        cb.mark();
        // me posiciono en 5
        cb.position(5);
        System.out.println("El caracter en la posición 5 es " + cb.get());
        // retorno a donde había establecido la marca (final)
        //cb.reset();
        //System.out.println("El caracter en la posición de la marca es " + cb.get());

        System.out.println("El caracter en la posición 2 es " + cb.get(2));
        // HE LEIDO EN UNA POSICIÓN ABSOLUTA, NO CAMBIA EL VALOR DE POSITION
        System.out.println("Estoy en la posición " + cb.position());
    }
}
