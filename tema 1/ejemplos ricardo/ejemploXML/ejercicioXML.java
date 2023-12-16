package com.ian;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EjercicoXML {

    public static void main(String[] args) {
        crea();
        muestra();

    }

    private static void crea() {
        List<Disco> listaDisco = new ArrayList<>();
        listaDisco.add(new Disco(1,"Un verano sin ti",200));
        listaDisco.add(new Disco(2,"Ferxxo",20));
        listaDisco.add(new Disco(3,"Justin20",70));

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            builder = factory.newDocumentBuilder();
            DOMImplementation dom = builder.getDOMImplementation();
            Document documento = dom.createDocument(null, "DiscosXML", null);
            Element raiz = documento.createElement("Discos");
            documento.getDocumentElement().appendChild(raiz);
            Element nodoDatos;
            Element nodoDisco;
            Text texto;

            for (Disco disco: listaDisco){
                nodoDisco = documento.createElement("Disco");
                raiz.appendChild(nodoDisco);

                nodoDatos = documento.createElement("Id");
                nodoDisco.appendChild(nodoDatos);
                texto = documento.createTextNode(String.valueOf(disco.getId()));
                nodoDatos.appendChild(texto);

                nodoDatos = documento.createElement("titulo");
                nodoDisco.appendChild(nodoDatos);
                texto = documento.createTextNode(disco.getTitulo());
                nodoDatos.appendChild(texto);

                nodoDatos = documento.createElement("precio");
                nodoDisco.appendChild(nodoDatos);
                texto = documento.createTextNode(String.valueOf(disco.getPrecio()));
                nodoDatos.appendChild(texto);
            }

            Source source = new DOMSource(documento);
            Result resultado = new StreamResult(new File("discos.xml"));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty("indent","yes");
            transformer.transform(source,resultado);


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    private static void muestra() {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse("discos.xml");
            NodeList nodeList = doc.getElementsByTagName("Disco");
            Node node;
            Element element;

            for (int i = 0;i<nodeList.getLength();i++){
                node = nodeList.item(i);
                element = (Element) node;

                System.out.println("____Disco_"+(i+1)+"________");
                System.out.println("Id: "+ element.getElementsByTagName("Id").item(0).getTextContent());
                System.out.println("Titulo: "+ element.getElementsByTagName("titulo").item(0).getTextContent());
                System.out.println("Precio: "+ element.getElementsByTagName("precio").item(0).getTextContent());

            }


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

    }


}
