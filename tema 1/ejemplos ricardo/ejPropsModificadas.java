import java.util.*;
import java.io.*;

public class ejPropsModificadas {
    public static void main(String[] args) {
        try {
            Properties configuracion = new Properties();
            configuracion.load(new FileInputStream("configuracion.props"));
            String usuario = configuracion.getProperty("user");
            String password = configuracion.getProperty("password");
            String servidor = configuracion.getProperty("server");
            int puerto = Integer.valueOf(configuracion.getProperty("port"));

            Enumeration<Object> claves = configuracion.keys();
  
            while (claves.hasMoreElements()) {
                String clave = (String)claves.nextElement();
                System.out.println(clave.toString() + " = " + configuracion.get(clave));
            }

            configuracion.setProperty("user","user2");
            configuracion.setProperty("password","pass2");
            configuracion.store(new FileOutputStream("configuracion.conf"), "Configuracion.java");
            configuracion.list(System.out);
            } catch (FileNotFoundException fnfe ) {
                fnfe.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
    }
}
