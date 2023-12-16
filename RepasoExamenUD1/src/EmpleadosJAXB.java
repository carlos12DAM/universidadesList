import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class EmpleadosJAXB {
    @XmlElement
    private List<EmpleadoJAXB> empleados;

    public EmpleadosJAXB() {
        empleados = new ArrayList<>();
    }

    public EmpleadosJAXB(List<EmpleadoJAXB> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Empleados{" +
                "empleados=" + empleados +
                '}';
    }
}