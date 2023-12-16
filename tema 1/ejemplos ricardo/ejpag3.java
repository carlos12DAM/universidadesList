import java.nio.file.*;
import java.nio.charset.*;
import java.util.*;
import java.io.*;

public class texto
{
  public static void main(String[] args)
  {
    /*Path emptyFile = Paths.get("textos.txt");
    if (Files.notExists(emptyFile))
        emptyFile = Files.createFile(Paths.get("textos.txt"));*/
    try
    {
      FileSystem sistemaFicheros=FileSystems.getDefault();
      Path rutaFichero=sistemaFicheros.getPath("textos.txt");
      String text = "Esto es una cadena de prueba\n";
      Files.writeString(rutaFichero, text/*.getBytes(StandardCharsets.UTF_8)*/,
      StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
     
      text = "Esto es una segunda cadena de prueba\n";
      Files.writeString(rutaFichero, text/*.getBytes(StandardCharsets.UTF_8)*/,StandardOpenOption.APPEND);
     
      List<String> lines = Files.readAllLines(Paths.get("texto.txt"),StandardCharsets.UTF_8);
      for (String line : lines)
        System.out.println(line);
    }
    catch (IOException e)
    {
      System.err.println(e.getMessage());
    }
    
  }
}
