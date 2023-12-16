import java.sql.*;

/*Programa JDBC que acceda a la tabla categorias de la base de datos pedidos, para mostrar todas las fils cuya clave
* "categoriaid" sea inferior a 500. La cionsulta debe hacerse parametrizada, con un unico parametro que sea el valor 500
* en la ejecucion de la consulta*/


public class ejExamenJDBC1{
    public static void main(String[] args) {
        try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/pedidos","root","root");
            PreparedStatement stmt = con.prepareStatement("select * from categorias where categoriaid < ?"))
        {
            stmt.setInt(1,500);

            ResultSet rs = stmt.executeQuery();
            int id;
            String cat;

            while(rs.next()){
                id = rs.getInt(1);
                cat = rs.getString(2);

                System.out.println("id " + id + " nombre " + cat);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}


/*public class ejExamenJDBC1 {
    public static void main(String[] args) {
        try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pedidos","root","root");
            PreparedStatement stmt = con.prepareStatement("select * from categorias where categoriaid < ?", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);)
        {
            stmt.setInt(1,500);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);
                String nombre = rs.getString(2);

                System.out.println("id " + id + " nombre " + nombre);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}*/
