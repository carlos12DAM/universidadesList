public class PropiedadesSistema {
    public static void main(String[] args) {


        System.out.println("El separador de directorios es " + System.getProperty("file.separator"));
        System.out.println("El directorio de inicio de sesión del usuario es " + System.getProperty("user.home"));
        System.out.println("El directorio actual es " + System.getProperty("user.dir"));
        System.out.println("El separador de líneas es " + System.getProperty("line.separator"));

        }
}