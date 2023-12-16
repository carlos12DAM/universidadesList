import java.util.*;
import java.io.*;
public class escribirFicheroConfig {
    public static void main(String[] args) {
        Properties configuracion = new Properties();
        configuracion.setProperty("user","usuario1");
        configuracion.setProperty("password","pass1");
        configuracion.setProperty("server","miservidor");
        configuracion.setProperty("puerto","3306");
        try{
            configuracion.store(new FileOutputStream("configuracion.props"),"Fichero de configuracón");
        }catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch(IOException e){
          e.printStackTrace();
        }
    }
}
