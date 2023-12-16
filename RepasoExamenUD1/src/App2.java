import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/* App2. Programa que, dada la clase Libro (id,titulo,precio) haga uso de JAXB para generar un XML con una etiqueta "Libros" y 3 libros.

        @XmlRootElement
        @XmlAccessorType(XmlAccessType.FIELD)

            JAXBContext contexto = JAXBContext.newInstance( nombreClase.getClass() );
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); */
public class App2 {
    public static void main(String[] args) {
        try {
            //creo el objeto que vamos a escribir en el XML
            Libros libros = new Libros();
            libros.agregaLibros(new Libro(1, "El diario de Noah", 12.4));
            libros.agregaLibros(new Libro(2, "El diario de Greg", 18.6));
            libros.agregaLibros(new Libro(1, "Harry Potter y la Piedra Filosofal", 15.9));

            //Creo los objetos necesarios para poder generar el fichero XML.
            JAXBContext context = JAXBContext.newInstance(libros.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            //Serializo el objeto al fichero libros.xml.
            marshaller.marshal(libros,new File("files/libros.xml"));
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
}
