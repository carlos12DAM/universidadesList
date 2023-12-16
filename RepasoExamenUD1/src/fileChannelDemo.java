//Programa que escribe a fichero y posteriormente lee usando un fileChanel (canal)

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class fileChannelDemo{
    public static void main(String[] args) throws IOException {
        // añade el contenido al fichero
        writeFileChannel(ByteBuffer.wrap("bienvenido a dam2".getBytes()));
        //lee del fichero
        readFileChannel();
    }
    public static void readFileChannel() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("texto.txt","r");
        FileChannel fc = raf.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(512);
        Charset charset = Charset.forName("ISO-8859-15");
        while (fc.read(bb) > 0) {
            bb.flip();
            //byteBuffer.rewind();
            System.out.print(charset.decode(bb));
            //byteBuffer.flip();
            bb.rewind();
        }
        fc.close();
        raf.close();
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