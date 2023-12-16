import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class escribeLibrosJAXB{
    public static void main(String[] args) throws JAXBException {
        List<Libro> listaLibros = new ArrayList<>();

        listaLibros.add(new Libro(1,"popeye",23.70));
        listaLibros.add(new Libro(2,"piratas",43.90));
        listaLibros.add(new Libro(3,"pizzas",41.31));

        Libros libros = new Libros(listaLibros);
        JAXBContext context = JAXBContext.newInstance(libros.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        //Serializo el objeto al fichero libros.xml.
        marshaller.marshal(libros,new File("libros.xml"));


    }
}

