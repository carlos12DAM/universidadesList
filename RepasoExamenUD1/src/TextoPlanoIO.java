import java.io.*;
public class TextoPlanoIO
{
    static String texto;
    public static void main(String args[])
    {
        try(FileWriter fw = new FileWriter("pruebasIO.txt");){
            //escritura
            String texto = "Cadena de prueba";
            fw.write(texto);
            texto = "esto es una segunda de cadena de prueba";
            fw.write(texto);
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
        try(FileReader fr = new FileReader("pruebasIO.txt");
            BufferedReader br = new BufferedReader(fr))
        {
            //lectura
            while((texto = br.readLine()) !=null)
                System.out.println(texto);

        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}
