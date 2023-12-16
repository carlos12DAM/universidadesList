import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

/**
 *     App1. Programa quem haciendo uso de RandomAccessFile, genere un fichero aleatorio con 10 registros del tamaño de
 *     un entero de 4 bytes. El programa ha de pedir, o generar aleatoriamente, 5 enteros entre 1 y 10, y guardar cada
 *     valor en su posición. Si algún número se repite se añadirá secuencialmente al final del fichero (sólo para una
 *     primera colisión, si hubieran más no se escribirían).
 *
 *
 *     Genero 10 ficheros y guardo el numero en la posicion que sea igual a este*/

public class App1 {
        static int TAM = 4; //defino el tamaño de cada registro (4 bytes porque es int)
       static int MAX = 10; //Defino el máximo de registros que puedo tener

    public static void main(String[] args) {

            //Genero números.
            int numeros[] = new int[5];

            for(int i=0 ; i < 5 ; i++) {
                numeros[i] = (int)(Math.random() * 10 + 1); //+1 es para que llegue al 10
                //muestro los numeros aleatorios del array
                System.out.println(numeros[i]);

            }
            //Escribo los numeros en el raf
            try(RandomAccessFile raf = new RandomAccessFile("RAFnio.dat","rw");){

                //Antes de escribir cada numero tengo que comprobar que se ha guardado en el raf
                for(int num:numeros) {
                    //si es true ya existe el numero
                    if (comprobador(num) == true){

                        //me posicono al final del fichero (porque esta )
                        raf.seek(MAX*TAM);
                        raf.writeInt(num);


                    }else{
                        //me posiciono
                        raf.seek(num*TAM);
                        //ESCRIBO EL NUMERO
                        raf.writeInt(num);
                    }
                }
            }catch(EOFException e){

            }catch(IOException e){
                e.printStackTrace();
            }
    }
    public static boolean comprobador(int num){ //le paso el numero
        boolean respuesta = false;

            try(RandomAccessFile raf = new RandomAccessFile("RAFnio.dat","rw");) {

                //me posiciono en la posicion que sea igual a ese numero
                raf.seek((num)*TAM);
                //Leo el numero dentro de este registro
                int numero = raf.readInt();

                //Si el numero es 0 significa que no hay nada en esa posicion
                //si es distinto de 0 hay un numero en esa posicion
                if(numero != 0){
                    respuesta = true;
                }

            }catch(EOFException e){

            }catch(IOException e){
                e.printStackTrace();
            }
            return respuesta;

    }

}
