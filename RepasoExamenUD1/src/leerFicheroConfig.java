import java.util.*;
import java.nio.*;
import java.io.*;

public class leerFicheroConfig
{
    public static void main(String[] args)
    {
        String usuario,password,servidor;
        int puerto;
        Properties configuracion = new Properties();
        try
        {
            configuracion.load(new FileInputStream("configuracion.props"));
			System.out.println(usuario = configuracion.getProperty("user"));
			System.out.println(password = configuracion.getProperty("password"));
			System.out.println(servidor = configuracion.getProperty("server"));
			System.out.println(puerto = Integer.valueOf(configuracion.getProperty("puerto")));
            configuracion.list(System.out);
        }
        catch (FileNotFoundException fnfe )
        {
            fnfe.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
