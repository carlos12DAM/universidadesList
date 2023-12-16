import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class leeEmpleadosJAXB {
    public static void main(String[] args) {
        EmpleadosJAXB empleados = null;
        try {
            JAXBContext context = JAXBContext.newInstance(EmpleadosJAXB.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();
            empleados = (EmpleadosJAXB) unmarshaller.unmarshal(new File("empleados.xml") );

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        System.out.println(empleados);
    }
}
