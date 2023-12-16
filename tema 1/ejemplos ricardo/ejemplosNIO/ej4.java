// ScatterGatherExample
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.channels.*;

public class ej4 {
    public static void main(String[] args) throws IOException {
        String data = "Scattering and Gathering examples!";
        String file = "write.txt";
        gatherBytes(file, data);
        scatterBytes(file);
    }

    public static FileChannel createChannelInstance(String file, boolean isOutput) {
        FileChannel fileChannel = null;
        try {
            if (isOutput) {
                fileChannel = new FileOutputStream(file).getChannel();
                //fileChannel = FileChannel.open(Paths.get(file), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            } else {
                fileChannel = new FileInputStream(file).getChannel();
                //fileChannel = FileChannel.open(Paths.get(file));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileChannel;
    }

    //gatherBytes() is used for reading the bytes from the buffers and write it to a file channel
    public static void gatherBytes(String file, String data) throws IOException {
        //The First Buffer is used for holding a number
        ByteBuffer buffer1 = ByteBuffer.allocate(8);
        //The Second Buffer is used for holding a data that we want to write
        ByteBuffer buffer2 = ByteBuffer.allocate(400);
        buffer1.asIntBuffer().put(420);
        buffer2.asCharBuffer().put(data);
        GatheringByteChannel gatherer = createChannelInstance(file, true);

        //write the data into file
        try {
            gatherer.write(new ByteBuffer[]{buffer1, buffer2});
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //scatterBytes() is used for reading the bytes from a file channel into a set of buffers.
    public static void scatterBytes(String file) {
        //The First Buffer is used for holding a random number
        ByteBuffer buffer1 = ByteBuffer.allocate(8);
        //The Second Buffer is used for holding a data that we want to write
        ByteBuffer buffer2 = ByteBuffer.allocate(400);
        ScatteringByteChannel scatter = createChannelInstance(file, false);
        //Reading a data from the channel
        try {
            scatter.read(new ByteBuffer[]{buffer1, buffer2});
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Read the two buffers seperately
        buffer1.rewind();
        buffer2.rewind();

        int bufferOne = buffer1.asIntBuffer().get();
        String bufferTwo = buffer2.asCharBuffer().toString();
        //Verification of content
        System.out.println(bufferOne);
        System.out.println(bufferTwo);
    }

}

