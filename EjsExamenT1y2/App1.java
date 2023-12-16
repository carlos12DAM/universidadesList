import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *     App1. Programa quem haciendo uso de RandomAccessFile, genere un fichero aleatorio con 10 registros del tamaño de
 *     un entero de 4 bytes. El programa ha de pedir, o generar aleatoriamente, 5 enteros entre 1 y 10, y guardar cada
 *     valor en su posición. Si algún número se repite se añadirá secuencialmente al final del fichero (sólo para una
 *     primera colisión, si hubieran más no se escribirían).
 *
 *
 *     Genero 10 ficheros y guardo el numero en la posicion que sea igual a este*/

public class App1 {

    static int TAM = 4;
    static int MAX = 10;
    public static void main(String[] args) {

        int numeros[] = new int[5];

        for(int i = 0 ; i < 5 ; i++){
            numeros[i] = (int)(Math.random() * 10 + 1);
            System.out.println(numeros[i]);
        }
        try(RandomAccessFile raf = new RandomAccessFile("aleatorios.dat","rw")){
            for(int num:numeros){
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


        } catch (EOFException es){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean comprobador(int num){

        boolean respuesta = false;
        try(RandomAccessFile raf = new RandomAccessFile("aleatorios.dat","rw")){

            //me posiciono en la posicion que sea igual a ese numero
            raf.seek((num)*TAM);
            //Leo el numero dentro de este registro
            int numero = raf.readInt();

            //Si el numero es 0 significa que no hay nada en esa posicion
            //si es distinto de 0 hay un numero en esa posicion
            if(numero != 0){
                respuesta = true;
            }

        } catch (EOFException es){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return respuesta;
    }
}
