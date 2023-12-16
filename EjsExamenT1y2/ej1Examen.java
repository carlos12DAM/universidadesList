import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*Programa que pida una serie de pares de valores numericos (el primero entero positivo, el segundo real)
 y almacene los segundos en un fichero de acceso aleatorio, cada real en la posicion indicada por el entero.
 El programa acabara cuando el introducido sea 0*/
//Explica en el codigo como queda definido el tamaño final del fichero.

public class ej1Examen{
    static Scanner ent = new Scanner(System.in);
    static int TAM = 8;
    static int pos;
    static double num;
    public static void main(String[] args) {
        int opcion;

        while (true) {
            System.out.println("Introduce una opcion:\n 1 -> Introducir\n 2 -> mostrar\n 0 -> salir ");
            opcion = ent.nextInt();

            switch (opcion){
                case 1:añadir();break;
                case 2:mostrar();break;
                case 0:System.exit(0);break;
                default:
                    System.out.println("opcion no valida");

            }

        }
    }

    private static void añadir() {

        try(RandomAccessFile raf = new RandomAccessFile("lalala.bin","rw")){
            System.out.println("intro posi");
            pos = ent.nextInt();
            System.out.println("intro numero");
            num = ent.nextDouble();

            raf.seek((pos-1)*TAM);
            raf.writeDouble(num);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void mostrar() {
        int cont=1;

        try(RandomAccessFile raf = new RandomAccessFile("lalala.bin","r")){

            while(true){
                num = raf.readDouble();
                if(num != 0){

                    System.out.println("posicion -> " + cont + " numero " + num);
                }
                cont++;
            }


        } catch (EOFException e){

        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}



/*public class ej1Examen {

    static Scanner ent = new Scanner(System.in);
    static int posicion;
    static double numero;
    static int TAM = 8;
    public static void main(String[] args) {

        int opcion;

        while(true) {

        System.out.println("Introduce una opcion:\n 1 -> Introducir\n 2 -> mostrar\n 0 -> salir ");
        opcion = ent.nextInt();

            switch (opcion) {
                case 1: add();break;
                case 2: mostrar();break;
                case 0: System.exit(0);break;
                default:
                    System.out.println("opcion no valida");
            }
        }
    }
    private static void add() {
        try(RandomAccessFile raf = new RandomAccessFile("numeros.bin","rw");
        ){
            System.out.println("introduce la posicion");
            posicion = ent.nextInt();
            System.out.println("introduce el numero");
            numero = ent.nextDouble();

            raf.seek((posicion -1) * TAM);
            raf.writeDouble(numero);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void mostrar() {

        int cont = 1;

        try(RandomAccessFile raf = new RandomAccessFile("numeros.bin","r");
        ){
            while(true){
                numero = raf.readDouble();
                if(numero != 0){
                    System.out.println("posicion -> " + cont + " numero " + numero);
                }
                    cont++;
            }
        }catch(EOFException e) {

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}*/
