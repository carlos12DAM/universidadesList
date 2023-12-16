import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


/*Programa que pida una serie de pares de valores numericos (el primero entero positivo, el segundo real)
 y almacene los segundos en un fichero de acceso aleatorio, cada real en la posicion indicada por el entero.
 El programa acabara cuando el introducido sea 0*/
//Explica en el codigo como queda definido el tamaño final del fichero.

public class ej1Examen{
    static Scanner ent = new Scanner(System.in);
    static int TAM = 8; //porque un double ocupa 8 bytes
    static int posicion;
    static double numero;
    public static void main(String[] args) {
        int opcion;

        while(true) {
            System.out.println("Introduce una opcion:\n 1 -> Introducir\n 2 -> mostrar\n 0 -> salir ");
            opcion = ent.nextInt();

            //primero creo un menu
            switch(opcion){
                case 1:introducir();break;
                case 2:mostrar();break;
                case 0:System.exit(0);break;
                default:
                    System.out.println("opcion no valida");break;
            }
        }
    }
    private static void introducir() {
        try(RandomAccessFile raf = new RandomAccessFile("ej1Examen.dat","rw");)
        {
            //primero le pedimos al usuario los dos valores
            System.out.println("Introduce la posicion");
            posicion = ent.nextInt();
            System.out.println("introduce el numero que se guardara en esa posicion");
            numero = ent.nextDouble();

            //me posiciono en la posicion introducida
            raf.seek((posicion-1) * TAM);
            //escribo el numero en esa posicion
            raf.writeDouble(numero);

        }catch(IOException e){
            e.printStackTrace();
        }

    }
    private static void mostrar() {
        try(RandomAccessFile raf = new RandomAccessFile("ej1Examen.dat","r");)
        {

            System.out.println("-----NUMEROS ALMACENADOS-----");

            int cont = 1; //para indicar la posicion

            while(true)
            {
                numero = raf.readDouble();
                if(numero != 0)
                    System.out.println("posicion " + cont + " numero " + numero);
                cont++;
            }

        }catch(EOFException e){

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

//RESPUESTA PREGUNTA
//El tamaño quedara definido dependiendo de la cantidad de registros que tenga el RAF.
//en mi caso 15 (la posicion) registros * 8 Bytes que ocupa cada uno = 120 bytes.