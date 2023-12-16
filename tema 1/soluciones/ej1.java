/* 1. Crea una fichero de acceso aleatorio para guardar registros de empleados con

	id (dni sin letra), entero largo
	nombre, String con un máximo de 28 bytes
	salario, double
	
De esa manera, cada empleado ocupará 8 + 28 + 8 = 44 bytes
	
Cada empleado se guardará en la posición indicada por las 3 últimas cifras del DNI. El programa ofrecerá un menú con las opciones, como mínimo, alta de un nuevo empleado y consulta de un empleado existente (a partir del DNI). El programa habrá de permitir colisiones, guardando los sinónimos al final del fichero.

El fichero, con contenido vacío, lo puedes crear con el comando "truncate -s tamaño nomFichero". */

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ej1 {
    static Scanner ent = new Scanner(System.in);
    final static int TAM = 40;	// 4 (int) + 8 (double) + 28 (String limitado) = 40 Bytes

    public static void main(String[] args) {

        do{
            System.out.println("********************");
            System.out.println("Escoge una opción:");
            System.out.println("1. Alta de empleado");
            System.out.println("2. Mostrar");
            System.out.println("0. Salir del programa");
            System.out.println("********************");

            int i = ent.nextInt();

            switch(i){
                case 1: alta();break;
                case 2: mostrar();break;
                case 0: System.exit(0);
                default:
                    System.out.println("Error, opción incorrecta\n");
            }

        }while( true );

    }
    //Falta cambiar que guarde usuarios del 1 al 1000 y no del 000 al 999
    public static void alta(){
        System.out.println("\nPrograma");
        try(RandomAccessFile raf = new RandomAccessFile("dniEmpleados.dat","rw")){

            System.out.println("Introduce un DNI sin letra");
            int dni = ent.nextInt();
            // descargar la pulsación de intro
            ent.nextLine();
            System.out.println("Introduce su nombre");
            String nombre = ent.nextLine();
            System.out.println("Introduce salario");
            double salario = ent.nextDouble();


            int id = dni%1000; //Me quedo con los tres últimos dígitos del dni para usarlo como id
            System.out.println("El id ahora es: "+id);//Compruebo que me quedo con los tres últimos dígitos
            raf.seek((long)id*TAM); // Te posicionas en la posición que le corresponde a ese, id

            //Leo esa posición y compruebo si esa posición está vacía, de ser así guardo el nombre.
            int compruebaDNI = raf.readInt();
            if (compruebaDNI == 0)    // la posición está libre
            {
                //Me vuelvo a posicionar en el principio
                raf.seek((long)id*TAM);
                System.out.println("Compruebo que escribe bien "+nombre);
                // ESCRIBIMOS EL DNI, NO EL ID
                raf.writeInt(dni);
                nombre = nombre.substring(0,Math.min(nombre.length(),26)); //es 26 y no 28 porque de los 28 los 2 primeros bytes no son para guardar caracteres, en ellos guarda la longitud
                raf.writeUTF(nombre);
                raf.writeDouble(salario);
            }
            else    // la posición estaba ocupada
            {
                //Me posiciono al final del fichero y guardo ahí el empleado con un "id" que ya existe en otro empleado
                raf.seek(raf.length());
                // ESCRIBIMOS EL DNI, NO EL ID
                raf.writeInt(dni);
                nombre = nombre.substring(0,Math.min(nombre.length(),26)); //es 26 y no 28 porque de los 28 los 2 primeros bytes no son para guardar caracteres, en ellos guarda la longitud
                raf.writeUTF(nombre);
                raf.writeDouble(salario);
            }



        }catch(EOFException ignored){

        }catch(IOException e){

        }
    }

    public static  void mostrar(){

        try(RandomAccessFile raf = new RandomAccessFile("dniEmpleados.dat","r")){
		String nom=""; double salario;
            System.out.println("Introduce el DNI del empleado");
            int dni = ent.nextInt();
            int id = dni % 1000;

            raf.seek((long) id *TAM);

            //una vez posicionado, muestro el empleado
            int valor = raf.readInt();
            /* 3 posibilidades: 
            	1) no está en su posición (hay un hueco)
            	2) sí está
            	3) hay otro (sinónimo o colisión), en tal caso miro al final */
	    if (valor == 0)
	    	System.out.println("No existe");
	    else
	    {
	    	if (valor == dni)
	    	{
	    		nom = raf.readUTF();
	    		salario = raf.readDouble();
	    		// falta mostrarlo, lo hago al final
	    	}
	    	else
	    	{
	    		raf.seek(40000);
	    		int dniLeido = raf.readInt();
	    		while (dniLeido != dni)
	    		{
	    			nom = raf.readUTF();
	    			salario = raf.readDouble();
	    			dniLeido = raf.readInt();
	    		}
	    		nom = raf.readUTF();
	    		salario = raf.readDouble();
	    		// falta mostrarlo ...
	    	}
	    	// lo muestro
	    	System.out.println("Su nombre es " + nom + " y su salario es " + salario);
	    }

        }catch(IOException e){
            System.err.println(e.getMessage());
        }

    }
}
