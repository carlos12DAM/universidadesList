import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.xml.sax.*;

public class leeXML
{
	public static void main(String[] args) throws SAXException,IOException,ParserConfigurationException {

    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation dom = builder.getDOMImplementation();
		Document documento = builder.parse(new File("archivo.xml"));

        NodeList productos = documento.getElementsByTagName("producto");

        for (int i = 0; i < productos.getLength(); i++) {
            Node producto = productos.item( i ) ;
            Element elemento = ( Element ) producto ;
            /* System.out.println(elemento.getElementsByTagName("nombre").item(0).getChildNodes().item(0).getNodeValue());
            System.out.println(elemento.getElementsByTagName("precio").item(1).getChildNodes().item(0).getNodeValue());
            System.out.println(elemento.getElementsByTagName("precio").item(0).getTextContest());*/
            System.out.println(elemento.getNodeValue());
    }
    }
}
