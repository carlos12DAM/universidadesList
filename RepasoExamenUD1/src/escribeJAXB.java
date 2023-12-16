
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class escribeJAXB
{
    public static void main( String[] args )
    {
        List<EmpleadoJAXB> empleados = new ArrayList<>();
        empleados.add(new EmpleadoJAXB(1,"Tomas Primo",3405));
        empleados.add(new EmpleadoJAXB(2,"Carlos Primo",3500));
        empleados.add(new EmpleadoJAXB(3,"Alejandro Romero",2200));

        EmpleadosJAXB emps = new EmpleadosJAXB(empleados);

        try {
            JAXBContext contexto = JAXBContext.newInstance(
            emps.getClass() );
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
             Boolean.TRUE);
            // marshaller.marshal(emps, System.out);
            marshaller.marshal(emps, new FileWriter("empleados.xml"));
			
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}