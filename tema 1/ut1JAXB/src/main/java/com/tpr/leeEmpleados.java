package com.tpr;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class leeEmpleados {
    public static void main(String[] args) {
        Empleados empleados = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Empleados.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();
             empleados = (Empleados) unmarshaller.unmarshal(new File("empleados.xml") );

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        System.out.println(empleados);
    }
}
