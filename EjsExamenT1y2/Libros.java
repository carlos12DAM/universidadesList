import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Libros{
    @XmlElement
    private List<Libro> libro;

    public Libros() {
    }

    public Libros(List<Libro> libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "libro=" + libro +
                '}';
    }
}

