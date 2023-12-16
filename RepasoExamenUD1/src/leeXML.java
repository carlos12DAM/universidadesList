import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class leeXML {
    public static void main(String[] args) {
        List<EmpleadoJAXB> listaEmpleados = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            documento = builder.parse(new File("empleados.xml"));
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        NodeList empleados = documento.getElementsByTagName("empleado");
        for (int i=0 ; i < empleados.getLength() ; i++)
        {
            Node emp = empleados.item(i);
            Element elemento = (Element) emp;
            int id = Integer.parseInt(elemento.getElementsByTagName("id").item(0).getChildNodes().item(0).getNodeValue());
            String nombre =  elemento.getElementsByTagName("nombre").item(0).getChildNodes().item(0).getNodeValue();
            double salario = Double.parseDouble(elemento.getElementsByTagName("salario").item(0).getChildNodes().item(0).getNodeValue());
            EmpleadoJAXB empleado = new EmpleadoJAXB(id, nombre, salario);
            listaEmpleados.add(empleado);
        }

        for (EmpleadoJAXB e : listaEmpleados)
            System.out.println(e);
    }
}
