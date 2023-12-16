// Programa que escribe los 10s primeros números naturales en binario a fichero

import java.io.*;
public class numerosBINARIOS {
    public static void main(String[] args) {
        //programa que escriba 10 numeros en binario a fichero y luego los lea
        File archivoBinario = new File("numeros.bin");

        //escritura del archivo
        try(FileOutputStream fos = new FileOutputStream(archivoBinario);
            DataOutputStream dos = new DataOutputStream(fos);){

            for(int i=1 ; i <= 10 ; i++)
                dos.writeDouble(Math.random());
        }catch(IOException e){
            System.out.println("No se ha encontrado el archivo");
            System.err.println(e.getMessage());
        }
    }
}
