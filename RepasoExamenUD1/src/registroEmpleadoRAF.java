import java.io.*;
import java.util.*;
public class registroEmpleadoRAF {
    static Scanner ent = new Scanner(System.in);
    final static int TAM = 44;

    public static void main(String[] args) {
        do{
            System.out.println("Escoge una opción:");
            System.out.println("1. Alta de empleado");
            System.out.println("2. Mostrar");
            System.out.println("0. Salir del programa");
            int i = ent.nextInt();

            switch(i){
                case 1:alta();break;
                case 2:mostrar();break;
                case 0:System.exit(0);
                default:
                    System.out.println("Opcion no valida");
            }
        }while(true);
    }
    public static void alta(){
        System.out.println("----APARTADO DE DAR DE ALTA UN EMPLEADO----");
        try(RandomAccessFile raf = new RandomAccessFile("empleados.dat","rw")){

            System.out.println("introduce el id del empleado (funciona como posicionamiento)");
            long id = ent.nextLong();
            // descargar la pulsación de intro
            ent.nextLine();
            System.out.println("Introduce su nombre");
            String nombre = ent.nextLine();

            System.out.println(nombre + "con string");

            System.out.println("Introduce salario");
            double salario = ent.nextDouble();

            raf.seek((id-1)*TAM);
            raf.writeLong(id);
            nombre = nombre.substring(0,Math.min(nombre.length(),26)); //es 26 y no 28 porque de los 28 los 2 primeros bytes no son para guardar caracteres, en ellos guarda la longitud
            raf.writeUTF(nombre);
            raf.writeDouble(salario);

        }catch(EOFException ignored){

        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    public static void mostrar(){
        System.out.println("----APARTADO DE MOSTRAR UN EMPLEADO----");
        try(RandomAccessFile raf = new RandomAccessFile("empleados.dat","r")){

            System.out.println("Introduce el id del empleado");
            long idMostrar = ent.nextLong();
            raf.seek((idMostrar-1)*TAM); //TAM = tamaño q va a ocupar cada registro del raf (no siempre es 44)

            //una vez posicionado muestro el empleado
            long id = raf.readLong();
            String nombre = raf.readUTF();
            double salario = raf.readDouble();
            System.out.println("id: " + id  + " \nNombre: " + nombre + " \nSalario: " + salario);

        }catch(IOException e){
            System.err.println(e.getMessage());
        }

    }
}
