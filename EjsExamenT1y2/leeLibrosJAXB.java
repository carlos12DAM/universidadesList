import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class leeLibrosJAXB {
    public static void main(String[] args) throws JAXBException {
        Libros libros = null;
        //creo el contexto
        JAXBContext contexto = JAXBContext.newInstance(Libros.class);
        //creo el unmarshaler
        Unmarshaller unmarshaller = contexto.createUnmarshaller();
        libros = (Libros) unmarshaller.unmarshal(new File("libros.xml"));

        System.out.println(libros);
    }
}
