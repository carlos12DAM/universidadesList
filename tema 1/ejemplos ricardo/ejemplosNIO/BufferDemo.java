import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferDemo {
	public static void main (String [] args) {
		//crear buffer para 10 caracteres
		CharBuffer buffer = CharBuffer.allocate(10);
		String text = "bufferDemo";
		System.out.println("Input text: " + text);
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			//escribir caracter en el buffer.
			buffer.put(c);
		}
		int buffPos = buffer.position();
		System.out.println("Posición después de la escritura en el buffer: " + buffPos);
		buffer.flip();
		System.out.println("Leyendo contenido del buffer:");
		while (buffer.hasRemaining()) {
			System.out.println(buffer.get());
		}
		// estableciendo la posición del buffer en 5.
		buffer.position(5);
		// estableciendo la marca según la posición
		buffer.mark();
		// intentando volver a cambiar la posición
		buffer.position(6);
		// utilizando el método reset para restaurar la posición marcada
		// reset() lanza InvalidMarkException si la marca no se puede establecer
		// o si la nueva posición es inferior que la posición marcada
		buffer.reset();
		System.out.println("Restaurada la posición del buffer: " + buffer.position());
        System.out.println(buffer.get());
	}
}
