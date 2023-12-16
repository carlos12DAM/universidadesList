import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;

public class escribeXML
{
	public static void main(String[] args) throws ParserConfigurationException,TransformerException {

		Producto p1 = new Producto("alicates",(float)23.1);
		Producto p2 = new Producto("destornillador",(float)7.16);
		Vector<Producto> listaProductos = new Vector<Producto>();
		listaProductos.add(p1);
		listaProductos.add(p2);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation dom = builder.getDOMImplementation();
		Document documento = dom.createDocument(null, "xml", null);
		Element raiz = documento.createElement("productos");
		documento.getDocumentElement().appendChild(raiz);
		Element nodoProducto = null , nodoDatos = null ;
		Text texto = null;

		for (Producto producto : listaProductos) {
			nodoProducto = documento.createElement("producto");
			raiz.appendChild(nodoProducto);

			nodoDatos = documento.createElement("nombre");
			nodoProducto.appendChild(nodoDatos);
			texto = documento.createTextNode(producto.getNombre());
			nodoDatos.appendChild(texto);

			nodoDatos = documento.createElement("precio");
			nodoProducto.appendChild(nodoDatos);
			texto = documento.createTextNode(String.valueOf(producto.getPrecio()));
			nodoDatos.appendChild(texto);
		}
		Source source = new DOMSource(documento);
		Result resultado = new StreamResult(new File("archivo.xml"));

		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		//transformer.transform(new StreamSource(source), new StreamResult(resultado));
    transformer.setOutputProperty("indent","yes");
		transformer.transform(source,resultado);
	}
}
