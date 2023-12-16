import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class escribeXML {
    public static void main(String[] args) {
        List<EmpleadoJAXB> empleados = new ArrayList<>();
        empleados.add(new EmpleadoJAXB(1,"Pepe Pérez",2000));
        empleados.add(new EmpleadoJAXB(2,"JUlián Muñoz",1000));
        empleados.add(new EmpleadoJAXB(3,"Sergio Ramos",1500));

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation dom = builder.getDOMImplementation();
            Document documento = dom.createDocument(null, "xml", null);
            Element raiz = documento.createElement("empleados");
            documento.getDocumentElement().appendChild(raiz);
            Element nodoProducto = null , nodoDatos = null ;
            Text texto = null;

            for(EmpleadoJAXB emp : empleados)
            {
                nodoProducto = documento.createElement("empleado");
                raiz.appendChild(nodoProducto);

                nodoDatos = documento.createElement("id");
                nodoProducto.appendChild(nodoDatos);
                texto = documento.createTextNode(String.valueOf(emp.getId()));
                nodoDatos.appendChild(texto);

                nodoDatos = documento.createElement("nombre");
                nodoProducto.appendChild(nodoDatos);
                texto = documento.createTextNode(emp.getNombre());
                nodoDatos.appendChild(texto);

                nodoDatos = documento.createElement("salario");
                nodoProducto.appendChild(nodoDatos);
                texto = documento.createTextNode(String.valueOf(emp.getSalario()));
                nodoDatos.appendChild(texto);
            }

            Source source = new DOMSource(documento);
            Result resultado = new StreamResult(new File("empleados.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty("indent","yes");
            transformer.transform(source,resultado);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}