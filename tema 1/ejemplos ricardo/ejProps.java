import java.util.*;
import java.io.*;

public class ejProps
{
    public static void main(String args[])
    {
        Properties configuracion = new Properties();
        configuracion.setProperty("user", "user1");
        configuracion.setProperty("password", "pass1");
        configuracion.setProperty("server", "miservidor");
        configuracion.setProperty("port", "3306");
        try {
            configuracion.store(new FileOutputStream("configuracion.props"),"Fichero de configuracion");
        } catch (FileNotFoundException fnfe ) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
