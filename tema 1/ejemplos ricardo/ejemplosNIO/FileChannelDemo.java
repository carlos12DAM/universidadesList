import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class FileChannelDemo {
	public static void main(String args[]) throws IOException {
		// añade el contenido al fichero
		writeFileChannel(ByteBuffer.wrap("Welcome to DAM2".getBytes()));
		// lee el fichero
		readFileChannel();
	}
	public static void readFileChannel() throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile("temp.txt","r");
		FileChannel fileChannel = randomAccessFile.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(512);
		Charset charset = Charset.forName("ISO-8859-15");
		while (fileChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();			
            //byteBuffer.rewind();
			System.out.print(charset.decode(byteBuffer));
			//byteBuffer.flip();
            byteBuffer.rewind();
		}
		fileChannel.close();
		randomAccessFile.close();
	}
	public static void writeFileChannel(ByteBuffer byteBuffer)throws IOException {
		Set<StandardOpenOption> options = new HashSet<>();
		options.add(StandardOpenOption.CREATE);
		options.add(StandardOpenOption.APPEND);
		Path path = Paths.get("temp.txt");
		FileChannel fileChannel = FileChannel.open(path, options);
		fileChannel.write(byteBuffer);
		fileChannel.close();
	}
}
